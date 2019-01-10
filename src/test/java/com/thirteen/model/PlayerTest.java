package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the player class.
 *
 * @author Michael Kha
 */
public class PlayerTest {

    /**
     * Name to be used tests
     */
    public static final String NAME = "a name";

    /**
     * Component under test
     */
    private Player CuT;

    /**
     * Friendly objects
     */
    private Deck deck;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        deck = new Deck(new Stack<>());
        CuT = new Player(NAME);
    }

    /**
     * Test that the name is retrieved.
     */
    @Test
    public void testGetName() {
        assertEquals(CuT.getName(), NAME);
    }

    /**
     * Test that the hand is retrieved.
     */
    @Test
    public void testGetHand() {
        Hand hand = CuT.getHand();
        assertEquals(hand.size(), 0);
    }

    /**
     * Test that setting the passed state works correctly.
     */
    @Test
    public void testSetPassed() {
        CuT.setPassed(true);
        assertTrue(CuT.hasPassed());
    }

    /**
     * Test that the passed value is returned.
     */
    @Test
    public void testHasPassed() {
        assertFalse(CuT.hasPassed());
    }

    /**
     * Test that cards can be added to the hand.
     */
    @Test
    public void testAddToHand() {
        assertTrue(CuT.isHandEmpty());
        Card card = deck.dealACard();
        CuT.addToHand(card);
        assertFalse(CuT.isHandEmpty());
    }

    /**
     * Test that cards in the hand can be removed.
     */
    @Test
    public void testRemoveFromHand() {
        Card card = deck.dealACard();
        CuT.addToHand(card);
        assertFalse(CuT.isHandEmpty());
        CuT.removeFromHand(card);
        assertTrue(CuT.isHandEmpty());
    }

    /**
     * Test that the hand can be checked to see if it is full.
     */
    @Test
    public void testIsHandFull() {
        assertEquals(CuT.getHand().isEmpty(), CuT.isHandEmpty());
    }

    /**
     * Test that the hand can be checked to see if it is empty.
     */
    @Test
    public void testIsHandEmpty() {
        assertEquals(CuT.getHand().isFull(), CuT.isHandFull());
    }

}
