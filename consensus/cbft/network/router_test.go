package network

import (
	"bytes"
	"crypto/rand"
	"fmt"
	"sync"
	"testing"
	"time"

	"github.com/PlatONnetwork/PlatON-Go/p2p"

	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/types"

	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/protocols"

	"github.com/PlatONnetwork/PlatON-Go/common"

	"github.com/PlatONnetwork/PlatON-Go/p2p/discover"

	"github.com/stretchr/testify/assert"
)

var (
	presetMessageHash = common.BytesToHash([]byte("preset hash"))
	testingPeerCount  = 10
)

// Create a new router for testing.
func newRouter(t *testing.T) (*router, *peer) {
	// Create a peerSet for assistance.
	ps := NewPeerSet()
	var consensusNodes []discover.NodeID
	writer, reader := p2p.MsgPipe()
	var localId discover.NodeID
	rand.Read(localId[:])
	localPeer := NewPeer(1, p2p.NewPeer(localId, "local", nil), reader)
	for i := 0; i < testingPeerCount; i++ {
		p, id := newLinkedPeer(writer, 1, fmt.Sprintf("p%d", i))
		ps.Register(p)
		if i%2 != 0 {
			consensusNodes = append(consensusNodes, id)
		}
	}
	unregisterHook := func(id string) error {
		return ps.Unregister(id)
	}
	getHook := func(id string) (*peer, error) {
		return ps.Get(id)
	}
	consensusNodesHook := func() ([]discover.NodeID, error) {
		return consensusNodes, nil
	}
	peersHook := func() ([]*peer, error) {
		return ps.Peers(), nil
	}
	router := NewRouter(unregisterHook, getHook, consensusNodesHook, peersHook)
	peers, _ := router.peers()
	t.Logf("peers: %s", formatPeers(peers))
	t.Logf("consensusuPeers: %s", formatDiscoverNodeIDs(consensusNodes))
	return router, localPeer
}

// testing gossip protocol.
func Test_Router_Gossip(t *testing.T) {
	// Do some work to complete the initialization.
	// localPeer stands for local node.
	// peers statnds for the node of remote.
	r, localPeer := newRouter(t)

	testCases := []struct {
		message types.Message
		mode    uint64
	}{
		{&protocols.PrepareBlockHash{1, 1, 1, common.Hash{}, 1}, types.FullMode},
		{&protocols.PrepareBlockHash{1, 1, 1, common.Hash{}, 1}, types.PartMode},
	}
	// Keep sending message.
	go func() {
		for _, p := range testCases {
			// Broadcast message.
			// Build a message bundle to gossip.
			r.Gossip(types.NewMsgPackage("", p.message, p.mode))
		}
	}()

	// Keep receiving message.
	go func() {
		for {
			msg, err := localPeer.ReadWriter().ReadMsg()
			if err != nil {
				t.Log("read message failed", err)
			}
			switch msg.Code {
			case protocols.PrepareBlockHashMsg:
				t.Log("gossip message success.")
			default:
				t.Fatal("Error message code")
			}
			msg.Discard()
			t.Logf("messageType: %d", msg.Code)
		}
	}()
	// Waiting for the test to complete.
	time.Sleep(2 * time.Second)
}

func Test_Router_SendMessage(t *testing.T) {
	// init router and create local peer.
	r, localPeer := newRouter(t)
	peers, _ := r.peers()
	targetPeer := peers[0]

	testCases := []struct {
		message types.Message
		id      string
		mode    uint64
	}{
		{&protocols.GetLatestStatus{1, common.Hash{}, TypeForQCBn}, targetPeer.id, types.FullMode},
		{&protocols.LatestStatus{1, common.Hash{}, TypeForQCBn}, targetPeer.id, types.FullMode},
	}
	var wg sync.WaitGroup
	wg.Add(len(testCases))
	// Keep sending messages.
	for _, v := range testCases {
		go r.SendMessage(types.NewMsgPackage(v.id, v.message, v.mode))
	}
	// Keep receiving message.
	go func() {
		for {
			msg, err := localPeer.ReadWriter().ReadMsg()
			if err != nil {
				t.Log("read message failed", err)
			}
			switch msg.Code {
			case protocols.GetLatestStatusMsg, protocols.LatestStatusMsg:
				t.Log("send message success.")
			default:
				t.Fatal("Error message code")
			}
			t.Logf("messageType: %d", msg.Code)
			msg.Discard()
			wg.Done()
		}
	}()
	wg.Wait()
}

func Test_Router_FilteredPeers(t *testing.T) {
	// init router and preset hash.
	r, _ := newRouter(t)
	peers, _ := r.peers()
	excludePeer := peers[1]
	excludePeer.MarkMessageHash(presetMessageHash)

	// invoke filteredPeers to verify the func.
	// Get a list of different nodes according to different message types.
	// target: mixing -> 5 consensus, 5 non-consensus.
	// 		   consensus ->
	testCases := []struct {
		msgType uint64
		cond    common.Hash
	}{
		{protocols.PrepareBlockMsg, common.Hash{}},
		{protocols.PrepareVoteMsg, presetMessageHash},
		{protocols.PrepareBlockHashMsg, common.Hash{}},
		{protocols.PrepareBlockHashMsg, presetMessageHash},
	}
	for _, v := range testCases {
		peers, err := r.filteredPeers(v.msgType, v.cond)
		if err != nil {
			t.Error("filteredPeers failed", err)
		}
		t.Logf("filtered len: %d", len(peers))
		switch v.msgType {
		case protocols.PrepareBlockMsg, protocols.PrepareVoteMsg,
			protocols.ViewChangeMsg, protocols.BlockQuorumCertMsg:
			if v.cond == (common.Hash{}) {
				//assert.Equal(t, testingPeerCount, len(peers))
			} else {
				//assert.Equal(t, testingPeerCount-1, len(peers))
			}
		case protocols.PrepareBlockHashMsg:
			if v.cond == (common.Hash{}) {
				// todo: Let go later.
				//assert.Equal(t, testingPeerCount/2, len(peers))
			} else {
				//assert.Equal(t, testingPeerCount/2, len(peers))
			}
		}
	}
}

func Test_Router_kConsensusRandomNodes(t *testing.T) {
	r, _ := newRouter(t)
	peers, _ := r.peers()
	excludePeer := peers[2]
	excludePeer.MarkMessageHash(presetMessageHash)
	randomPeers, err := r.kConsensusRandomNodes(true, presetMessageHash)
	if err != nil {
		t.Error("kConsensusRandomNodes failed", err)
	}
	// The returned node list should not contain excluded nodes.
	t.Logf("len: %d", len(randomPeers))
	t.Log(formatPeers(randomPeers))
	for _, v := range randomPeers {
		if v.id == excludePeer.id {
			t.Errorf("should not be contain the peer :{%s}", excludePeer.id)
		}
	}
}

func Test_Router_KMixingRandomNodes(t *testing.T) {
	r, _ := newRouter(t)
	peers, _ := r.peers()
	excludePeer := peers[1]
	excludePeer.MarkMessageHash(presetMessageHash)
	randomPeers, err := r.kMixingRandomNodes(presetMessageHash)
	if err != nil {
		t.Error("kMixingRandomNodes failed", err)
	}
	// The returned node list should not contain excluded nodes.
	t.Logf("len: %d", len(randomPeers))
	t.Log(formatPeers(randomPeers))
	for _, v := range randomPeers {
		if v.id == excludePeer.id {
			t.Errorf("should not be contain the peer :{%s}", excludePeer.id)
		}
	}
}

func Test_Router_RepeatedCheck(t *testing.T) {
	// create new router and init peers.
	r, _ := newRouter(t)
	peers, err := r.peers()
	if err != nil {
		t.Error("create router failed")
	}
	peers[0].MarkMessageHash(presetMessageHash)
	if !r.repeatedCheck("p1", presetMessageHash) {
		t.Error("repeated check should be return true")
	}
	if r.repeatedCheck("p1", common.Hash{}) {
		t.Error("repeated check should not be return true")
	}
}

func Test_Router_FormatPeers(t *testing.T) {
	var peers []*peer
	var lastId string
	for i := 0; i < 3; i++ {
		p, _ := newPeer(1, fmt.Sprintf("p%d", i))
		peers = append(peers, p)
		lastId = p.id
	}
	assert.Contains(t, formatPeers(peers), lastId)
	t.Log(formatPeers(peers))
}

func formatDiscoverNodeIDs(ids []discover.NodeID) string {
	var bf bytes.Buffer
	for idx, id := range ids {
		bf.WriteString(id.TerminalString())
		if idx < len(ids)-1 {
			bf.WriteString(",")
		}
	}
	return bf.String()
}