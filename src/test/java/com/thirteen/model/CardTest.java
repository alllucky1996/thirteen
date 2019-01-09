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
     * Test that the correct ordinal value of the rank is returned.
     */
    @Test
    public void testGetRankOrdinal() {
        int fake = Rank.QUEEN.ordinal();
        int actual = CuT.getRankOrdinal();
        assertEquals(rank.ordinal(), actual);
        assertNotEquals(fake, actual);
    }

    /**
     * Test if two cards have the same rank, the correct boolean is returned.
     */
    @Test
    public void testIsSameRank() {
        Card sameRank = new Card(suit, rank);
        Card diffRank = new Card(suit, Rank.TWO);
        assertTrue(CuT.isSameRank(sameRank));
        assertFalse(CuT.isSameRank(diffRank));
    }

    /**
     * Test if two cards have the same rank, the correct boolean is returned.
     */
    @Test
    public void testIsRankAndSuit() {
        Rank two = Rank.TWO;
        Suit hearts = Suit.HEARTS;
        assertTrue(CuT.isRankAndSuit(rank, suit));
        assertFalse(CuT.isRankAndSuit(rank, hearts));
        assertFalse(CuT.isRankAndSuit(two, suit));
        assertFalse(CuT.isRankAndSuit(two, hearts));
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
        Object object = new Object();
        Card same = CuT;
        Card diffCard = new Card(diamonds, queen);
        Card sameSuit = new Card(suit, queen);
        Card sameRank = new Card(diamonds, rank);
        assertEquals(same, CuT);
        assertNotEquals(CuT, object);
        assertNotEquals(diffCard, CuT);
        assertNotEquals(sameSuit, CuT);
        assertNotEquals(sameRank, CuT);
    }

    /**
     * Test that the comparison between cards is correctly made.
     */
    @Test
    public void testCompareTo() {
        Card same = CuT;
        Card sameRank = new Card(Suit.SPADES, rank);
        Card higherRank = new Card(suit, Rank.TWO);
        assertEquals(CuT.compareTo(same), 0);
        assertEquals(CuT.compareTo(sameRank), 1);
        assertEquals(CuT.compareTo(higherRank), -1);
    }

    /**
     * Test that the string representation is returned correctly.
     */
    @Test
    public void testToString() {
        assertEquals(CuT.toString(), "Ace of Clubs");
    }

}
