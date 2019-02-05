package com.thirteen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suite for the round class.
 *
 * @author Michael Kha
 */
public class RoundTest {

    /**
     * Component under test
     */
    private Round CuT;

    /**
     * Friendly objects
     */
    private Game game;
    private Move move;

    /**
     * Setup the objects before each test
     */
    @BeforeEach
    public void setup() {
        game = new Game(4);
        game.start();
        move = new Move(new ArrayList<>());
        CuT = game.getCurrentRound();
        //CuT = new Round(game.getPlayers(), new ArrayList<>(), game.getCurrentPlayer());
    }

    /**
     * Test that the winner can be set.
     */
    @Test
    public void testSetWinner() {
        assertNull(CuT.getWinner());
        CuT.setWinner(CuT.getCurrent());
        assertEquals(CuT.getWinner(), CuT.getCurrent());
    }

    /**
     * Test that the winner can be retrieved.
     */
    @Test
    public void testGetWinner() {
        assertNull(CuT.getWinner());
    }

    /**
     * Test that the round has a winner.
     */
    @Test
    public void testHasWinner() {
        CuT.setWinner(CuT.getCurrent());
        assertTrue(CuT.hasWinner());
    }


    /**
     * Test that creating a turn returns the expected turn.
     */
    @Test
    public void testCreateTurn() {
        Turn expected = new Turn(CuT.getCurrent(), move);
        Turn actual = CuT.createTurn(move);
        assertEquals(actual.compareTo(expected), 0);
    }

    /**
     * Test that adding a turn to the list of turns properly updates the list.
     */
    @Test
    public void testAddTurn() {
        Turn turn = CuT.createTurn(move);
        CuT.addTurn(turn);
        assertEquals(CuT.size(), 1);
    }

    /**
     * Test that the list of turns is retrieved.
     */
    @Test
    public void testGetTurns() {
        List<Turn> turns = CuT.getTurns();
        assertTrue(turns.isEmpty());
    }

    /**
     * Test that the size is correctly returned.
     */
    @Test
    public void testSize() {
        assertEquals(CuT.size(), 0);
    }

    /**
     * Test that if there are no last turns, null is returned.
     */
    @Test
    public void testGetLastTurnIsNull() {
        assertNull(CuT.getLastTurn());
    }

    /**
     * Test that the last turn is retrieved given there are turns.
     */
    @Test
    public void testGetLastTurn() {
        Turn turn = CuT.createTurn(move);
        CuT.addTurn(turn);
        assertNotNull(CuT.getLastTurn());
    }

    /**
     * Test to check if a winner exists.
     * TODO: update for other cases
     */
    @Test
    public void testDoesWinnerExist() {
        assertFalse(CuT.doesWinnerExist());
        CuT.setWinner(CuT.getCurrent());
        assertTrue(CuT.doesWinnerExist());
    }

    /**
     * Test to check if all other players have indeed passed.
     * TODO: update for other cases
     */
    @Test
    public void testHaveAllOtherPlayersPassed() {
        assertFalse(CuT.haveAllOtherPlayersPassed(CuT.getCurrent()));
    }

}
