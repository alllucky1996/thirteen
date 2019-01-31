package com.thirteen.controller;

/**
 * Exception indicating invalid state reached by an instance of game.
 *
 * @author Michael Kha
 */
public class GameException extends Exception {

    /**
     * Create a new game exception with a given message.
     * @param message   Message to report
     */
    public GameException(String message) {
        super(message);
    }

}
