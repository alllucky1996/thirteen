package com.thirteen.model;

import java.util.List;

/**
 * Represents a hand of cards.
 *
 * @author Michael Kha
 */
public class Hand extends CardUpdater {

    /**
     * The maximum number of cards in the hand
     */
    private static final int HAND_LIMIT = 13;

    /**
     * Create a starting hand to be an empty list of cards.
     * @param cards List of cards to refer to as the hand
     */
    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Check if the hand's size is 13.
     * @return  If the hand is full
     */
    public boolean isFull() {
        return cards.size() == HAND_LIMIT;
    }

}
