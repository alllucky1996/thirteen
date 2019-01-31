package com.thirteen.controller;

import com.thirteen.model.Game;

/**
 * Manages the state of the game
 *
 * @author Michael Kha
 */
public class GameManager {

    /**
     * Game to be managed.
     */
    private Game game;

    /**
     * The game state to represent how the game is progressing
     */
    private GameState state;

    /**
     * Creates a game manager that controls the game through input.
     * @param game
     */
    public GameManager(Game game) {
        this.game = game;
        state = GameState.WAITING;
    }

    /**
     * Initialize the game.
     */
    public void init() {
        game.init();
        state = GameState.STARTING;
    }

    /**
     * Start the game
     */
    public void start() {
        game.start();
        state = GameState.IN_PROGRESS;
    }

    /**
     * Get the current state of the game.
     * @return  The game state
     */
    public GameState getState() {
        return state;
    }

}
