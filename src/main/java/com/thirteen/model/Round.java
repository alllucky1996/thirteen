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
     * The starting player of the round
     */
    private Player starter;

    /**
     * The winning player of the round
     */
    private Player winner;

    /**
     * Create a round with no turns and a starting player.
     * @param turns     Any empty list
     * @param starter   Starting player
     */
    public Round(List<Turn> turns, Player starter) {
        this.turns = turns;
        this.starter = starter;
    }

    /**
     * Get all the turns made this round.
     * @return  All the turns made
     */
    public List<Turn> getTurns() {
        return turns;
    }

    /**
     * Get the last turn made or null if no turns have occurred.
     * @return  The last turn made
     */
    public Turn getLastTurn() {
        return turns.isEmpty() ? null : turns.get(turns.size()-1);
    }

    /**
     * Get the starting player
     * @return  The starting player
     */
    public Player getStarter() {
        return starter;
    }

    /**
     * TODO: implement this
     * @return  If a winner can be declared for this round
     */
    public boolean doesWinnerExist() {
        return true;
    }

    /**
     * Set the winner to be the specified player
     * @param winner    Player that won
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * Get the winner of the round
     * @return  The winning player
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Has a winner been declared?
     * @return  If a winning player exists
     */
    public boolean hasWinner() {
        return winner != null;
    }
}
