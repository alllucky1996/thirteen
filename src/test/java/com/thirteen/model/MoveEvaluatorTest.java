package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the move evaluator class.
 *
 * @author Michael Kha
 */
public class MoveEvaluatorTest {

    /**
     * Friendly objects
     */
    private Deck deck;
    private Pile pile;
    private Move pass;
    private Move single;
    private Move pair;
    private Move triple;
    private Move quads;
    private Move sequence;
    private Move doubleSequence;
    private Move tripleSequence;
    private Move dragon;
    private Move quadTwos;

    /**
     * Create a pile ordered by rank.
     * @return  Pile of cards ordered by rank
     */
    private Pile createPile() {
        List<Card> stack = new Stack<>();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.BACK) {
                for (Suit suit : Suit.values()) {
                    if (suit != Suit.BACK) {
                        stack.add(new Card(suit, rank));
                    }
                }
            }
        }
        return new Pile(stack);
    }

    /**
     * Helper method to setup single moves.
     * @return  List of cards containing a single card
     */
    private List<Card> createSingle() {
        List<Card> single = new ArrayList<>();
        single.add(deck.cards.get(0));
        return single;
    }

    /**
     * Helper method to setup pair moves.
     * @return  List of cards containing a pair
     */
    private List<Card> createPair() {
        List<Card> pair = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            pair.add(pile.cards.get(i));
        }
        return pair;
    }

    /**
     * Helper method to setup triple moves.
     * @return  List of cards containing a triple
     */
    private List<Card> createTriple() {
        List<Card> triple = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            triple.add(pile.cards.get(i));
        }
        return triple;
    }

    /**
     * Helper method to setup quad moves.
     * @return  List of cards containing a quad
     */
    private List<Card> createQuads() {
        List<Card> quads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            quads.add(pile.cards.get(i));
        }
        return quads;
    }

    /**
     * Helper method to setup sequence moves.
     * @return  List of cards containing a sequence
     */
    private List<Card> createSequence() {
        List<Card> seq = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            seq.add(deck.cards.get(i));
        }
        return seq;
    }

    /**
     * Helper method to setup double sequence moves.
     * @return  List of cards containing a double sequence
     */
    private List<Card> createDoubleSequence() {
        List<Card> dSeq = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dSeq.add(deck.cards.get(i));
            dSeq.add(deck.cards.get(i + 13));
        }
        return dSeq;
    }

    /**
     * Helper method to setup triple sequence moves.
     * @return  List of cards containing a triple sequence
     */
    private List<Card> createTripleSequence() {
        List<Card> tSeq = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tSeq.add(deck.cards.get(i));
            tSeq.add(deck.cards.get(i + 13));
            tSeq.add(deck.cards.get(i + 26));
        }
        return tSeq;
    }

    /**
     * Helper method to setup dragon moves.
     * @return  List of cards containing a dragon
     */
    private List<Card> createDragon() {
        List<Card> dragon = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            dragon.add(deck.cards.get(i));
        }
        return dragon;
    }

    /**
     * Helper method to setup the quad two move.
     * @return  List of cards containing quad twos
     */
    private List<Card> createQuadTwos() {
        List<Card> quads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            quads.add(pile.cards.get(pile.size() - 1 - i));
        }
        return quads;
    }

    /**
     * Create a move from any number of cards. For easier creation of moves.
     * @param cards Card params
     * @return  Move made from cards
     */
    private Move createMove(Card... cards) {
        List<Card> cardList = new ArrayList<>(Arrays.asList(cards));
        return new Move(cardList);
    }

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        deck = new Deck(new Stack<>());
        pile = createPile();
        pass = new Move(new ArrayList<>());
        single = new Move(createSingle());
        pair = new Move(createPair());
        triple = new Move(createTriple());
        quads = new Move(createQuads());
        sequence = new Move(createSequence());
        doubleSequence = new Move(createDoubleSequence());
        tripleSequence = new Move(createTripleSequence());
        dragon = new Move(createDragon());
        quadTwos = new Move(createQuadTwos());
    }

    /**
     * Test that the possible types of moves are not determined to be illegal.
     */
    @Test
    public void testLegalPlays() {
        assertNotEquals(pass.getPlay(), Play.ILLEGAL);
        assertNotEquals(single.getPlay(), Play.ILLEGAL);
        assertNotEquals(pair.getPlay(), Play.ILLEGAL);
        assertNotEquals(triple.getPlay(), Play.ILLEGAL);
        assertNotEquals(quads.getPlay(), Play.ILLEGAL);
        assertNotEquals(sequence.getPlay(), Play.ILLEGAL);
        assertNotEquals(doubleSequence.getPlay(), Play.ILLEGAL);
        assertNotEquals(tripleSequence.getPlay(), Play.ILLEGAL);
        assertNotEquals(dragon.getPlay(), Play.ILLEGAL);
        assertNotEquals(quadTwos.getPlay(), Play.ILLEGAL);
    }

    /**
     * Test that these moves are determined to be illegal.
     * Each case has a "bad" card as the last card in the params.
     * Cases should return illegal plays.
     */
    @Test
    public void testIllegalPlays() {
        // Pair
        assertEquals(createMove(
                pile.cards.get(1), pile.cards.get(4)).getPlay(), Play.ILLEGAL);
        // 3 Card Sequence
        assertEquals(createMove(
                deck.cards.get(2), deck.cards.get(3), deck.cards.get(0))
                .getPlay(), Play.ILLEGAL);
        // 3 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(2), deck.cards.get(3), deck.cards.get(51))
                .getPlay(), Play.ILLEGAL);
        // 4 Card Sequence
        assertEquals(createMove(
                deck.cards.get(3), deck.cards.get(4), deck.cards.get(5),
                deck.cards.get(0)).getPlay(), Play.ILLEGAL);
        // 4 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(3), deck.cards.get(4), deck.cards.get(5),
                deck.cards.get(51)).getPlay(), Play.ILLEGAL);
        // 5, 7, 11 Card Sequence
        assertEquals(createMove(
                deck.cards.get(2), deck.cards.get(3), deck.cards.get(4),
                deck.cards.get(5), deck.cards.get(0)).getPlay(),
                Play.ILLEGAL);
        // 5, 7, 11 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(2), deck.cards.get(3), deck.cards.get(4),
                deck.cards.get(5), deck.cards.get(51)).getPlay(),
                Play.ILLEGAL);
        // 6, 8, 10 Card Sequence
        assertEquals(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(0))
                .getPlay(), Play.ILLEGAL);
        // 6, 8, 10 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(51))
                .getPlay(), Play.ILLEGAL);
        // 9 Card Sequence
        assertEquals(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(16),
                deck.cards.get(27), deck.cards.get(28), deck.cards.get(0))
                .getPlay(), Play.ILLEGAL);
        // 9 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(16),
                deck.cards.get(27), deck.cards.get(28), deck.cards.get(51))
                .getPlay(), Play.ILLEGAL);
        // 12 Card Sequence: Doubles
        assertEquals(createMove(
                deck.cards.get(0), deck.cards.get(1), deck.cards.get(2),
                deck.cards.get(3), deck.cards.get(4), deck.cards.get(5),
                deck.cards.get(13), deck.cards.get(14), deck.cards.get(15),
                deck.cards.get(16), deck.cards.get(17), deck.cards.get(0))
                .getPlay(), Play.ILLEGAL);
        // 12 Card Sequence: Triples
        assertEquals(createMove(
                deck.cards.get(0), deck.cards.get(1), deck.cards.get(2),
                deck.cards.get(3), deck.cards.get(13), deck.cards.get(14),
                deck.cards.get(15), deck.cards.get(16), deck.cards.get(26),
                deck.cards.get(27), deck.cards.get(28), deck.cards.get(0))
                .getPlay(), Play.ILLEGAL);
        // 12 Card Sequence: contains 2
        assertEquals(createMove(
                deck.cards.get(0), deck.cards.get(1), deck.cards.get(2),
                deck.cards.get(3), deck.cards.get(4), deck.cards.get(5),
                deck.cards.get(13), deck.cards.get(14), deck.cards.get(15),
                deck.cards.get(16), deck.cards.get(17), deck.cards.get(51))
                .getPlay(), Play.ILLEGAL);
        // 13 Card Sequence
        assertEquals(createMove(
                deck.cards.get(13), deck.cards.get(14), deck.cards.get(15),
                deck.cards.get(16), deck.cards.get(17), deck.cards.get(18),
                deck.cards.get(19), deck.cards.get(20), deck.cards.get(21),
                deck.cards.get(22), deck.cards.get(23), deck.cards.get(24),
                deck.cards.get(0)).getPlay(), Play.ILLEGAL);
        // Default (more than 13 cards in hand move)
        assertEquals(createMove(
                deck.cards.get(13), deck.cards.get(14), deck.cards.get(15),
                deck.cards.get(16), deck.cards.get(17), deck.cards.get(18),
                deck.cards.get(19), deck.cards.get(20), deck.cards.get(21),
                deck.cards.get(22), deck.cards.get(23), deck.cards.get(24),
                deck.cards.get(25), deck.cards.get(0)).getPlay(),
                Play.ILLEGAL);
    }

}
