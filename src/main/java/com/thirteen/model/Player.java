package com.thirteen.model;

import java.util.ArrayList;

/**
 * Represents a player in the game of Thirteen.
 *
 * @author Michael Kha
 */
public class Player {

    /**
     * Constants used for default naming
     */
    private static final String DEFAULT_NAME = "Player";

    private static final String NAME_DELIMITER = " ";

    private static int PLAYER_NUMBER = 1;

    /**
     * The player's name
     */
    private String name;

    /**
     * The player's hand of cards
     */
    private Hand hand;

    /**
     * Create a player with the default name.
     */
    public Player() {
        this(DEFAULT_NAME + NAME_DELIMITER + PLAYER_NUMBER);
    }

    /**
     * Create a player with a specified name.
     * @param name  Name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand(new ArrayList<>());
    }

    /**
     * Get the player's name
     * @return  Player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the player's hand
     * @return  Player's name
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Add a card to the player's hand
     * @param card  Card to add
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * Use a card in the player's hand.
     * @param card  Card to use
     */
    public void useInHand(Card card) {
        hand.remove(card);
    }


}
