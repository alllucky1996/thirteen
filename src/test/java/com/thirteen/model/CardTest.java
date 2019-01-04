package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the card class.
 *
 * @author Michael Kha
 */
public class CardTest {

    /**
     * Component under test
     */
    private Card CuT;

    /**
     * Friendly objects
     */
    private Suit suit;
    private Rank rank;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        suit = Suit.CLUBS;
        rank = Rank.ACE;
        CuT = new Card(suit, rank);
    }

    /**
     * Test that the correct suit is retrieved.
     */
    @Test
    public void testGetSuit() {
        Suit fake = Suit.DIAMONDS;
        Suit actual = CuT.getSuit();
        assertEquals(suit, actual);
        assertNotEquals(fake, actual);
    }

    /**
     * Test that the correct rank is retrieved.
     */
    @Test
    public void testGetRank() {
        Rank fake = Rank.QUEEN;
        Rank actual = CuT.getRank();
        assertEquals(rank, actual);
        assertNotEquals(fake, actual);
    }

    /**
     * Test that another object is equal to the CuT.
     */
    @Test
    public void testEquals() {
        Card sameCard = new Card(suit, rank);
        assertEquals(sameCard, CuT);
    }

    /**
     * Test that another object is not equal to the CuT.
     */
    @Test
    public void testNotEquals() {
        Suit diamonds = Suit.DIAMONDS;
        Rank queen = Rank.QUEEN;
        Card diffCard = new Card(diamonds, queen);
        Card sameSuit = new Card(suit, queen);
        Card sameRank = new Card(diamonds, rank);
        assertNotEquals(diffCard, CuT);
        assertNotEquals(sameSuit, CuT);
        assertNotEquals(sameRank, CuT);
    }

}
