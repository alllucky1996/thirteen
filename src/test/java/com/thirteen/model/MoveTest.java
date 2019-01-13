package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the move class.
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
     * Test that the proper high card is returned.
     */
    @Test
    public void testGetHighCard() {
        assertNull(pass.getHighCard());
        assertEquals(single.getHighCard(), deck.cards.get(0));
        assertEquals(pair.getHighCard(), pile.cards.get(1));
        assertEquals(triple.getHighCard(), pile.cards.get(2));
        assertEquals(quads.getHighCard(), pile.cards.get(3));
        assertEquals(sequence.getHighCard(), deck.cards.get(3));
        assertEquals(doubleSequence.getHighCard(), deck.cards.get(15));
        assertEquals(tripleSequence.getHighCard(), deck.cards.get(28));
        assertEquals(dragon.getHighCard(), deck.cards.get(12));
        assertEquals(quadTwos.getHighCard(), pile.cards.get(pile.size() - 1));
    }

    /**
     * Test that the comparison made is correct.
     */
    @Test
    public void testCompareTo() {
        assertEquals(single.compareTo(createMove(deck.cards.get(1))), -1);
        assertEquals(pair.compareTo(createMove(
                pile.cards.get(1), pile.cards.get(2))), -1);
        assertEquals(triple.compareTo(createMove(
                pile.cards.get(1), pile.cards.get(2), pile.cards.get(3))), -1);
        assertEquals(quads.compareTo(createMove(
                pile.cards.get(4), pile.cards.get(5), pile.cards.get(6),
                pile.cards.get(7))), -1);
        assertEquals(sequence.compareTo(createMove(
                deck.cards.get(3), deck.cards.get(4), deck.cards.get(5),
                deck.cards.get(6))), -1);
        assertEquals(doubleSequence.compareTo(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(16))),
                -1);
        assertEquals(tripleSequence.compareTo(createMove(
                deck.cards.get(1), deck.cards.get(2), deck.cards.get(3),
                deck.cards.get(14), deck.cards.get(15), deck.cards.get(16),
                deck.cards.get(27), deck.cards.get(28), deck.cards.get(29))),
                -1);
        assertEquals(dragon.compareTo(createMove(
                deck.cards.get(13), deck.cards.get(14), deck.cards.get(15),
                deck.cards.get(16), deck.cards.get(17), deck.cards.get(18),
                deck.cards.get(19), deck.cards.get(20), deck.cards.get(21),
                deck.cards.get(22), deck.cards.get(23), deck.cards.get(24),
                deck.cards.get(25))), -1);
        assertEquals(dragon.compareTo(quadTwos), -1);
    }

}
