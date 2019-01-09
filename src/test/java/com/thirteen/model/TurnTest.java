package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test suite for the turn class.
 *
 * @author Michael Kha
 */
public class TurnTest {

    /**
     * Component under test
     */
    private Turn CuT;
    private Turn previousTurn;

    /**
     * Friendly objects
     */
    private Player player;
    private Player previousPlayer;
    private Deck deck;
    private Move move;
    private Move previousMove;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        player = new Player("current");
        previousPlayer = new Player("previous");
        deck = new Deck(new Stack<>());
        List<Card> cardsInMove = new ArrayList<>();
        cardsInMove.add(deck.cards.get(1));
        move = new Move(cardsInMove);
        List<Card> cardsInPreviousMove = new ArrayList<>();
        cardsInPreviousMove.add(deck.cards.get(0));
        previousMove = new Move(cardsInPreviousMove);
        CuT = new Turn(player, move);
        previousTurn = new Turn(previousPlayer, previousMove);
    }

    /**
     * Test that the same player is retrieved.
     */
    @Test
    public void testGetPlayer() {
        assertEquals(CuT.getPlayer(), player);
    }

    /**
     * Test that the same move is retrieved.
     */
    @Test
    public void testGetMove() {
        assertEquals(CuT.getMove(), move);
    }

    /**
     * Test that the comparison of turns defaults to the move comparison.
     */
    @Test
    public void testCompareTo() {
        assertEquals(CuT.compareTo(previousTurn),
                move.compareTo(previousMove));
    }

}
