package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the pile class.
 *
 * @author Michael Kha
 */
public class PileTest {

    /**
     * Component under test
     */
    private Pile CuT;

    /**
     * Friendly objects
     */
    private Deck deck;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        deck = new Deck(new ArrayList<>());
        deck.shuffle();
        CuT = new Pile(new ArrayList<>());
    }

    /**
     * Test that the pile should be initially empty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(CuT.isEmpty());
    }

    /**
     * Test that the pile is not empty after having cards added.
     */
    @Test
    public void testIsNotEmpty() {
        CuT.add(deck.dealACard());
        assertFalse(CuT.isEmpty());
    }

    /**
     * Test that the size of the pile changes.
     */
    @Test
    public void testSize() {
        assertEquals(CuT.size(), 0);
        CuT.add(deck.dealACard());
        assertEquals(CuT.size(), 1);
    }

    /**
     * Test that the contents of the pile can be added directly.
     */
    @Test
    public void testAddAll() {
        CuT.addAll(deck.cards);
        assertEquals(CuT.size(), deck.size());
    }

}
