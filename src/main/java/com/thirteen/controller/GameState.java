package com.thirteen.controller;

/**
 * Game state to be used by the controller to identify actions to be taken.
 *
 * @author Michael Kha
 */
public enum GameState {
    /**
     * Game not yet initialized
     */
    WAITING,
    /**
     * Game now in progress
     */
    IN_PROGRESS,
    /**
     * Game over
     */
    GAME_OVER

}
