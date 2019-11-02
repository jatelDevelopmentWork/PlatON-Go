package core

import (
	"crypto/rand"
	"encoding/binary"
	"fmt"
	"io/ioutil"
	"math/big"
	"os"
	"testing"
	"time"

	"github.com/PlatONnetwork/PlatON-Go/crypto"

	"github.com/PlatONnetwork/PlatON-Go/common"
	"github.com/PlatONnetwork/PlatON-Go/common/hexutil"
	"github.com/PlatONnetwork/PlatON-Go/consensus"
	"github.com/PlatONnetwork/PlatON-Go/core/snapshotdb"
	"github.com/PlatONnetwork/PlatON-Go/core/state"
	"github.com/PlatONnetwork/PlatON-Go/ethdb"
	"github.com/PlatONnetwork/PlatON-Go/trie"
	"github.com/stretchr/testify/assert"
)

var (
	testKey, _  = crypto.HexToECDSA("b71c71a67e1177ad4e901695e1b4b9ee17ae16c6668d313eac2f96dbcda3f291")
	testAddress = crypto.PubkeyToAddress(testKey.PublicKey)

	securePreifx = []byte("secure-key-")
)

func randBytes(n int) []byte {
	r := make([]byte, n)
	rand.Read(r)
	return r
}

func newBlockChainForTesting(db ethdb.Database) (*BlockChain, error) {
	buf, err := ioutil.ReadFile("../eth/downloader/testdata/platon.json")
	if err != nil {
		return nil, err
	}

	var gen Genesis
	if err := gen.UnmarshalJSON(buf); err != nil {
		return nil, err
	}

	gen.Alloc[testAddress] = GenesisAccount{
		Code:    nil,
		Storage: nil,
		Balance: big.NewInt(10000000000),
		Nonce:   0,
	}

	block, _ := gen.Commit(db, snapshotdb.Instance())

	return GenerateBlockChain(gen.Config, block, new(consensus.BftMock), db, 200, func(i int, block *BlockGen) {
		block.statedb.SetState(testAddress, []byte(fmt.Sprintf("abc_%d", i+1)), []byte(fmt.Sprintf("abccccccc_%d", i+1)))
	}), nil
}

func TestCleaner(t *testing.T) {
	tmpDir, err := ioutil.TempDir("", "platon")
	assert.Nil(t, err)
	defer os.RemoveAll(tmpDir)

	db, err := ethdb.NewLDBDatabase(tmpDir, 100, 1024)
	assert.Nil(t, err)

	blockchain, err := newBlockChainForTesting(db)
	assert.Nil(t, err)
	assert.NotNil(t, blockchain)

	cleaner := NewCleaner(blockchain, 100, time.Minute, false)
	cleaner.lastNumber = 0
	assert.NotNil(t, cleaner)
	assert.True(t, cleaner.NeedCleanup())
	cleaner.interval = 200
	assert.False(t, cleaner.NeedCleanup())

	cleaner.lastNumber = 0
	cleaner.interval = 100
	cleaner.cleanTimeout = time.Nanosecond
	cleaner.Cleanup()
	time.Sleep(100 * time.Millisecond)
	fmt.Println(cleaner.lastNumber)
	assert.True(t, cleaner.lastNumber == 1)

	cleaner.lastNumber = 0
	cleaner.cleanTimeout = time.Minute
	cleaner.Cleanup()
	assert.True(t, cleaner.cleaning.IsSet())
	time.Sleep(500 * time.Millisecond) // Waiting cleanup finish
	assert.True(t, cleaner.lastNumber == 100)
	assert.False(t, cleaner.cleaning.IsSet())

	cleaner.gcMpt = true
	cleaner.lastNumber = 0
	cleaner.Cleanup()
	time.Sleep(50 * time.Millisecond)
	assert.True(t, cleaner.lastNumber == 100)

	block := blockchain.GetBlockByNumber(188)
	_, err = blockchain.StateAt(block.Root())
	assert.NotNil(t, err)

	block = blockchain.GetBlockByNumber(200)
	statedb, _ := blockchain.StateAt(block.Root())
	assert.NotNil(t, statedb)
	buf := statedb.GetState(testAddress, []byte(fmt.Sprintf("abc_%d", block.NumberU64())))
	assert.Equal(t, string(buf), fmt.Sprintf("abccccccc_%d", block.NumberU64()))

	cleaner.Stop()

	cleaner = NewCleaner(blockchain, 200, time.Minute, false)
	assert.Equal(t, cleaner.lastNumber, uint64(100))
}

func TestStopCleaner(t *testing.T) {
	tmpDir, _ := ioutil.TempDir("", "platon")
	defer os.RemoveAll(tmpDir)

	db, err := ethdb.NewLDBDatabase(tmpDir, 100, 1024)
	assert.Nil(t, err)

	blockchain, err := newBlockChainForTesting(db)
	assert.Nil(t, err)

	cleaner := NewCleaner(blockchain, 100, time.Minute, false)
	assert.False(t, cleaner.stopped.IsSet())
	cleaner.Cleanup()
	time.Sleep(time.Millisecond)
	cleaner.Stop()
	assert.True(t, cleaner.stopped.IsSet())
}

func TestFilter(t *testing.T) {
	tmpDir, _ := ioutil.TempDir("", "platon")
	defer os.RemoveAll(tmpDir)

	db, err := ethdb.NewLDBDatabase(tmpDir, 100, 1024)
	assert.Nil(t, err)

	blockchain, err := newBlockChainForTesting(db)
	assert.Nil(t, err)

	cleaner := NewCleaner(blockchain, 100, time.Minute, false)
	cleaner.OnNode([]byte("m-abc"))
	cleaner.OnPreImage([]byte("secure-key-abcde"))

	assert.False(t, cleaner.writeFilterTest([]byte("abc")))
	assert.False(t, cleaner.writeFilterTest([]byte("abcde")))
	assert.False(t, cleaner.writeFilterTest([]byte("123")))

	cleaner.cleaning.Set(true)
	cleaner.OnNode([]byte("m-abc"))
	cleaner.OnPreImage([]byte("secure-key-abcde"))
	assert.True(t, cleaner.writeFilterTest([]byte("abc")))
	assert.True(t, cleaner.writeFilterTest([]byte("abcde")))
}
