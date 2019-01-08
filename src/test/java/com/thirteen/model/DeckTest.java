package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the deck class.
 *
 * @author Michael Kha
 */
public class DeckTest {

    /**
     * Component under test
     */
    private Deck CuT;

    /**
     * Friendly objects
     */
    private List<Card> cards;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        cards = new Stack<>();
        CuT = new Deck(cards);
    }

    /**
     * Test that the 52-card deck is created consistently.
     */
    @Test
    public void testDeck() {
        Deck equivalentDeck = new Deck(cards);
        assertEquals(equivalentDeck, CuT);
    }

    /**
     * @deprecated
     * Test that the deck with jokers is created consistently.
     */
    //@Test
    public void testDeckWithJokers() {
        /*
        CuT = new Deck(cards, true);
        Deck hasJokersToo = new Deck(cards, true);
        assertEquals(hasJokersToo, CuT);
        */
    }

    /**
     * Test that the order of the cards is different.
     */
    @Test
    public void testShuffle() {
        Deck unshuffledDeck = new Deck(cards);
        CuT.shuffle();
        assertTrue(CuT.size() == unshuffledDeck.size());
        for (Card card : unshuffledDeck.cards) {
            assertTrue(CuT.getCards().contains(card));
        }
    }

    /**
     * Test that a card is removed from the deck and returned.
     */
    @Test
    public void testDealACard() {
        Card firstCard = CuT.getCards().get(0);
        int size = CuT.size();
        Card dealtCard = CuT.dealACard();
        int sizeAfter = CuT.size();
        assertEquals(firstCard, dealtCard);
        assertEquals(size - 1, sizeAfter);
    }

    /**
     * Test that the cards retrieved from two equivalent decks are equivalent.
     */
    @Test
    public void testGetCards() {
        Deck equivalentDeck = new Deck(cards);
        List<Card> equivalentCards = equivalentDeck.getCards();
        List<Card> CuTCards = CuT.getCards();
        for (int i=0; i<CuTCards.size(); i++) {
            assertEquals(equivalentCards.get(i), CuTCards.get(i));
        }
    }

    /**
     * Test that the size of the deck is correct.
     */
    @Test
    public void testSize() {
        int size = CuT.size();
        CuT.dealACard();
        int sizeAfter = CuT.size();
        assertEquals(size - 1, sizeAfter);
    }

    /**
     * Test that when the deck is empty, the method returns is true.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(CuT.isEmpty());
        int count = 0;
        while (count < 52) {
            CuT.dealACard();
            count++;
        }
        assertTrue(CuT.isEmpty());
    }

}
