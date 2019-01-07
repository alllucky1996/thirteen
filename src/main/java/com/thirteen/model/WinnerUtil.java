package com.thirteen.model;

/**
 * Utility interface for abstracting winner-related behavior.
 *
 * @author Michael Kha
 */
public interface WinnerUtil {

    /**
     * Does a winner exist?
     * @return  If a winner can be declared
     */
    boolean doesWinnerExist();

    /**
     * Set the winner to be the specified player.
     * @param winner    Player that won
     */
    void setWinner(Player winner);

    /**
     * Get the winner.
     * @return  The winning player
     */
    Player getWinner();

    /**
     * Has a winner been declared?
     * @return  If a winning player exists
     */
    boolean hasWinner();

}
