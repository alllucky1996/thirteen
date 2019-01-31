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
     * Game initialized
     */
    STARTING,
    /**
     * Four players still playing
     */
    IN_PROGRESS,
    /**
     * Three players still playing
     */
    THREE_LEFT,
    /**
     * Two players still playing
     */
    TWO_LEFT,
    /**
     * One player still playing and signifies end of game
     */
    ONE_LEFT;

}
