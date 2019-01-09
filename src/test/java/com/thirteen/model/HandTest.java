package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the hand class.
 *
 * @author Michael Kha
 */
public class HandTest {

    /**
     * Component under test
     */
    private Hand CuT;

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
        CuT = new Hand(new ArrayList<>());
        for (int i=0; i<13; i++) {
            CuT.add(deck.dealACard());
        }
    }

    /**
     * Test that the hand is full or not.
     */
    @Test
    public void testIsFull() {
        assertTrue(CuT.isFull());
        CuT.remove(CuT.getCards().get(0));
        assertFalse(CuT.isFull());
    }

}
