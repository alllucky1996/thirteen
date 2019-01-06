package com.thirteen.model;

import java.util.List;

/**
 * Represents a round, consisting of a number of turns.
 * A round is a list of turns created upon the first turn of the
 * round being made. The first turn dictates the type of successive plays
 * that are possible.
 *
 * @author Michael Kha
 */
public class Round {

    /**
     * Turns that occurred within the round
     */
    private List<Turn> turns;

    /**
     * Create a round upon the first turn being made.
     * @param turns Any empty list
     * @param turn  Starting turn for the round
     */
    public Round(List<Turn> turns, Turn turn) {
        this.turns = turns;
        turns.add(turn);
    }

    /**
     * Get all the turns made this round.
     * @return  All the turns made
     */
    public List<Turn> getTurns() {
        return turns;
    }

    /**
     * Get the last turn made this round,
     * preconditions: turns is not empty
     * @return  The last turn made
     */
    public Turn getLastTurn() {
        return turns.get(turns.size()-1);
    }
}
