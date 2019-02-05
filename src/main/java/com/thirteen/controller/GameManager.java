package com.thirteen.controller;

import com.thirteen.model.Card;
import com.thirteen.model.Game;
import com.thirteen.model.Pile;

import java.util.List;

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
     * Initialize the game by dealing cards to the players.
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

    /**
     * Get the discard pile of the game.
     * @return  The discard pile
     */
    public Pile getDiscardPile() {
        return game.getDiscardPile();
    }

    /**
     * Make a move given a list of cards.
     * @param cards List of cards
     * @return If the move was successfully made
     */
    public boolean makeMove(List<Card> cards) {
        return game.makeMove(cards);
    }

    /**
     * Check if the game is over.
     * @return  Game is over or not
     */
    public boolean isGameOver() {
        return game.isGameOver();
    }

}
