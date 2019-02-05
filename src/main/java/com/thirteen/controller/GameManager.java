package com.thirteen.controller;

import com.thirteen.model.Game;
import com.thirteen.model.Pile;

/**
 * Manages the state of the game.
 *
 * @author Michael Kha
 */
public class GameManager {

    /**
     * Game to be managed
     */
    private Game game;

    /**
     * The game state to represent how the game is progressing
     */
    private GameState state;

    /**
     * Creates a game manager that controls the game through input.
     * @param game  Game to manage
     */
    public GameManager(Game game) {
        this.game = game;
        state = GameState.WAITING;
    }

    /**
     * Initialize the game by first shuffling deck and then dealing.
     */
    public void start() {
        game.shuffleDeck();
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

    /**
     * Get the discard pile of the game.
     * @return  The discard pile
     */
    public Pile getDiscardPile() {
        return game.getDiscardPile();
    }

    /**
     * Check if the game is over.
     * @return  Game is over or not
     */
    public boolean isGameOver() {
        return game.isGameOver();
    }

}
