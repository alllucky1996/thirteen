package com.thirteen.model;

/**
 * Represents a turn, a move made by a player.
 *
 * @author Michael Kha
 */
public class Turn implements Comparable<Turn> {

    /**
     * The player who played this turn
     */
    private Player player;

    /**
     * The move made on this turn
     */
    private Move move;

    /**
     * Create a turn consisting of the player making a move.
     * @param player    Player making a move
     * @param move      Move to be made
     */
    public Turn(Player player, Move move) {
        this.player = player;
        this.move = move;
    }

    /**
     * Get the player who played this turn.
     * @return  The player who is responsible
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the move made this turn.
     * @return  Move made
     */
    public Move getMove() {
        return move;
    }

    /**
     * Compare this turn to another turn. Turns are compared by
     * comparing the moves.
     * @param other Other move to compare with
     * @return  If this turn is less than, equal to, or greater than
     *          return -1, 0, or 1.
     */
    @Override
    public int compareTo(Turn other) {
        return move.compareTo(other.move);
    }
}
