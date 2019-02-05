package com.thirteen.model;

import java.util.List;

/**
 * TODO: update tests
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
     * Discard pile shared within the game
     */
    private Pile discardPile;

    /**
     * Index of the current player
     */
    private int index;

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
    public Round(List<Player> players, List<Turn> turns, Pile discardPile,
                 Player starter) {
        this.players = players;
        this.turns = turns;
        this.discardPile = discardPile;
        // Update current player index
        for (int i = 0; i < players.size(); i++) {
            if (starter == players.get(i)) {
                index = i;
                break;
            }
        }
        current = starter;
    }

    /**
     * Create a turn given a move.
     * @param move  Move to use in the turn
     * @return  A turn with the player that made a move
     */
    public Turn createTurn(Move move) {
        return new Turn(current, move);
    }

    /**
     * Add the specified turn to the list of turns.
     * @param turn  Turn to add
     * @return If the round added the turn or not
     */
    public boolean addTurn(Turn turn) {
        // Check last turn to make sure turns are followed
        Turn lastTurn = getLastTurn();
        if (lastTurn != null) {
            // Verify last player was the player who goes before current player
            if (lastTurn.getPlayer() == players.get(getLastIndex())
                && turn.getPlayer() == players.get(index)) {
                submitTurn(turn);
                return true;
            }
            return false;
        } else {
            submitTurn(turn);
            return true;
        }
    }

    /**
     * Submit the turn, updating the turn state, discard pile, and current
     * index player.
     * @param turn  Turn to submit
     */
    private void submitTurn(Turn turn) {
        turns.add(turn);
        discardPile.addAll(turn.getCards());
        updateCurrent();
    }

    /**
     * Update the current index and the current player.
     */
    private void updateCurrent() {
        index = index == players.size() - 1 ? 0 : ++index;
        current = players.get(index);
    }

    /**
     * Get the last player index.
     * @return The last player index
     */
    public int getLastIndex() {
        return index == 0 ? players.size() - 1 : index-1;
    }

    /**
     * Get all the turns made this round.
     * @return  All the turns made
     */
    public List<Turn> getTurns() {
        return turns;
    }

    /**
     * Get the size of the list of turns.
     * @return  Size of the list of turns
     */
    public int size() {
        return turns.size();
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
        if (hasWinner()) {
            return true;
        }
        // Compare player with other players
        for (Player player : players) {
            if (!player.hasPassed() && haveAllOtherPlayersPassed(player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if all other players have passed.
     * @param player    Player to exclude
     * @return  If all other players have passed or not
     */
    public boolean haveAllOtherPlayersPassed(Player player) {
        for (Player other : players) {
            if (player != other) {
                if (!other.hasPassed()) {
                    return false;
                }
            }
        }
        return true;
    }

}
