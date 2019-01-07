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
public class Round extends WinnerTool {

    /**
     * Players within the game
     */
    private List<Player> players;

    /**
     * Turns that occurred within the round
     */
    private List<Turn> turns;

    /**
     * The current player of the round
     */
    private Player current;

    /**
     * Create a round with no turns and a starting player.
     * @param players   Players playing the game
     * @param turns     Any empty list
     * @param starter   Starting player
     */
    public Round(List<Player> players, List<Turn> turns, Player starter) {
        this.players = players;
        this.turns = turns;
        current = starter;
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
     * Get the current player
     * @return  The current player
     */
    public Player getCurrent() {
        return current;
    }

    /**
     * Determine if a winner exists by looking at each player's hand
     * and seeing if other players have passed.
     * @return  If a winner can be declared for this round
     */
    public boolean doesWinnerExist() {
        // Compare player with other players
        for (Player player : players) {
            for (Player other : players) {
                if (player != other) {
                    // TODO: check if player needs to not have passed
                    if (player.isHandEmpty() && other.hasPassed()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
