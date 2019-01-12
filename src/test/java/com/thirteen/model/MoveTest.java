package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the move and move evaluator class.
 *
 * @author Michael Kha
 */
public class MoveTest {

    /**
     * Component under test
     */
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
     * Friendly objects
     */
    private Deck deck;
    private Pile pile;

    /**
     * Create a pile ordered by rank.
     * @return  Pile of cards ordered by rank
     */
    private Pile createPile() {
        List<Card> stack = new Stack<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                stack.add(new Card(suit, rank));
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
     * Test that for each possible play, the correct play is assigned
     * and returned.
     */
    @Test
    public void testGetPlay() {
        assertEquals(pass.getPlay(), Play.PASS);
        assertEquals(single.getPlay(), Play.SINGLE);
        assertEquals(pair.getPlay(), Play.PAIR);
        assertEquals(triple.getPlay(), Play.TRIPLE);
        assertEquals(quads.getPlay(), Play.FOUR_OF_A_KIND);
        assertEquals(sequence.getPlay(), Play.SEQUENCE);
        assertEquals(doubleSequence.getPlay(), Play.DOUBLE_SEQUENCE);
        assertEquals(tripleSequence.getPlay(), Play.TRIPLE_SEQUENCE);
        assertEquals(dragon.getPlay(), Play.DRAGON);
        assertEquals(quadTwos.getPlay(), Play.FOUR_TWOS);
    }

    /**
     *
     */
    @Test
    public void testGetHighCard() {
        assertNull(pass.getHighCard());
    }

    /**
     *
     */
    @Test
    public void testCompareHighestValue() {

    }

    /**
     *
     */
    @Test
    public void testCompareTo() {

    }

}
