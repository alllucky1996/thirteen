package com.thirteen.model;

/**
 * Concrete implementation of the WinnerUtil interface.
 * Controls access to the winning player.
 *
 * @author Michael Kha
 */
public abstract class WinnerTool implements WinnerUtil {

    /**
     * TODO: see if access modifier should be private or package-private
     * The winning player
     */
    private Player winner;

    /**
     * Set the winner to be the specified player.
     * @param winner    Player that won
     */
    @Override
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * Get the winner.
     * @return  The winning player
     */
    @Override
    public Player getWinner() {
        return winner;
    }

    /**
     * Has a winner been declared?
     * @return  If a winning player exists
     */
    @Override
    public boolean hasWinner() {
        return winner != null;
    }
}
