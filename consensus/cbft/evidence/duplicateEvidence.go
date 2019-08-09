package evidence

import (
	"bytes"
	"fmt"

	"github.com/PlatONnetwork/PlatON-Go/common/consensus"

	"github.com/PlatONnetwork/PlatON-Go/crypto"
	"github.com/PlatONnetwork/PlatON-Go/rlp"

	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/protocols"
)

//Evidence A.Number == B.Number but A.Hash != B.Hash
type DuplicatePrepareBlockEvidence struct {
	PrepareA *protocols.PrepareBlock
	PrepareB *protocols.PrepareBlock
}

func (d DuplicatePrepareBlockEvidence) BlockNumber() uint64 {
	return d.PrepareA.Block.NumberU64()
}

func (d DuplicatePrepareBlockEvidence) Epoch() uint64 {
	return d.PrepareA.Epoch
}

func (d DuplicatePrepareBlockEvidence) ViewNumber() uint64 {
	return d.PrepareA.ViewNumber
}

func (d DuplicatePrepareBlockEvidence) Hash() []byte {
	var buf []byte
	if ac, err := d.PrepareA.CannibalizeBytes(); err == nil {
		if bc, err := d.PrepareB.CannibalizeBytes(); err == nil {
			buf, err = rlp.EncodeToBytes([]interface{}{
				ac,
				d.PrepareA.Sign(),
				bc,
				d.PrepareB.Sign(),
			})
		}
	}
	return crypto.Keccak256(buf)
}

func (d DuplicatePrepareBlockEvidence) Equal(ev consensus.Evidence) bool {
	_, ok := ev.(*DuplicatePrepareBlockEvidence)
	if !ok {
		return false
	}
	dh := d.Hash()
	eh := ev.Hash()
	return bytes.Equal(dh, eh)
}

func (d DuplicatePrepareBlockEvidence) Error() string {
	return fmt.Sprintf("DuplicatePrepareBlockEvidence epoch:%d, viewNumber:%d, blockNumber:%d blockHashA:%s, blockHashB:%s",
		d.PrepareA.Epoch, d.PrepareA.ViewNumber, d.PrepareA.Block.NumberU64(), d.PrepareA.Block.Hash().String(), d.PrepareB.Block.Hash().String())
}

//Evidence A.Number == B.Number but A.Hash != B.Hash
type DuplicatePrepareVoteEvidence struct {
	VoteA *protocols.PrepareVote
	VoteB *protocols.PrepareVote
}

func (d DuplicatePrepareVoteEvidence) BlockNumber() uint64 {
	return d.VoteA.BlockNumber
}

func (d DuplicatePrepareVoteEvidence) Epoch() uint64 {
	return d.VoteA.Epoch
}

func (d DuplicatePrepareVoteEvidence) ViewNumber() uint64 {
	return d.VoteA.ViewNumber
}

func (d DuplicatePrepareVoteEvidence) Hash() []byte {
	var buf []byte
	if ac, err := d.VoteA.CannibalizeBytes(); err == nil {
		if bc, err := d.VoteB.CannibalizeBytes(); err == nil {
			buf, err = rlp.EncodeToBytes([]interface{}{
				ac,
				d.VoteA.Sign(),
				bc,
				d.VoteB.Sign(),
			})
		}
	}
	return crypto.Keccak256(buf)
}

func (d DuplicatePrepareVoteEvidence) Equal(ev consensus.Evidence) bool {
	_, ok := ev.(*DuplicatePrepareVoteEvidence)
	if !ok {
		return false
	}
	dh := d.Hash()
	eh := ev.Hash()
	return bytes.Equal(dh, eh)
}

func (d DuplicatePrepareVoteEvidence) Error() string {
	return fmt.Sprintf("DuplicatePrepareVoteEvidence epoch:%d, viewNumber:%d, blockNumber:%d blockHashA:%s, blockHashB:%s",
		d.VoteA.Epoch, d.VoteA.ViewNumber, d.VoteA.BlockNumber, d.VoteA.BlockHash.String(), d.VoteB.BlockHash.String())
}

//Evidence A.Number == B.Number but A.Hash != B.Hash
type DuplicateViewChangeEvidence struct {
	ViewA *protocols.ViewChange
	ViewB *protocols.ViewChange
}

func (d DuplicateViewChangeEvidence) BlockNumber() uint64 {
	return d.ViewA.BlockNumber
}

func (d DuplicateViewChangeEvidence) Epoch() uint64 {
	return d.ViewA.Epoch
}

func (d DuplicateViewChangeEvidence) ViewNumber() uint64 {
	return d.ViewA.ViewNumber
}

func (d DuplicateViewChangeEvidence) Hash() []byte {
	var buf []byte
	if ac, err := d.ViewA.CannibalizeBytes(); err == nil {
		if bc, err := d.ViewB.CannibalizeBytes(); err == nil {
			buf, err = rlp.EncodeToBytes([]interface{}{
				ac,
				d.ViewA.Sign(),
				bc,
				d.ViewB.Sign(),
			})
		}
	}
	return crypto.Keccak256(buf)
}

func (d DuplicateViewChangeEvidence) Equal(ev consensus.Evidence) bool {
	_, ok := ev.(*DuplicateViewChangeEvidence)
	if !ok {
		return false
	}
	dh := d.Hash()
	eh := ev.Hash()
	return bytes.Equal(dh, eh)
}

func (d DuplicateViewChangeEvidence) Error() string {
	return fmt.Sprintf("DuplicateViewChangeEvidence epoch:%d, viewNumber:%d, blockNumber:%d blockHashA:%s, blockHashB:%s",
		d.ViewA.Epoch, d.ViewA.ViewNumber, d.ViewA.BlockNumber, d.ViewA.BlockHash.String(), d.ViewB.BlockHash.String())
}

type EvidenceData struct {
	DP []*DuplicatePrepareBlockEvidence `json:"duplicate_prepare"`
	DV []*DuplicatePrepareVoteEvidence  `json:"duplicate_vote"`
	DC []*DuplicateViewChangeEvidence   `json:"duplicate_viewchange"`
}

func NewEvidenceData() *EvidenceData {
	return &EvidenceData{
		DP: make([]*DuplicatePrepareBlockEvidence, 0),
		DV: make([]*DuplicatePrepareVoteEvidence, 0),
		DC: make([]*DuplicateViewChangeEvidence, 0),
	}
}
func ClassifyEvidence(evds consensus.Evidences) *EvidenceData {
	ed := NewEvidenceData()
	for _, e := range evds {
		switch e.(type) {
		case *DuplicatePrepareBlockEvidence:
			ed.DP = append(ed.DP, e.(*DuplicatePrepareBlockEvidence))
		case *DuplicatePrepareVoteEvidence:
			ed.DV = append(ed.DV, e.(*DuplicatePrepareVoteEvidence))
		case *DuplicateViewChangeEvidence:
			ed.DC = append(ed.DC, e.(*DuplicateViewChangeEvidence))
		}
	}
	return ed
}