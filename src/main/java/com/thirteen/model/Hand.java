package com.thirteen.model;

import java.util.List;

/**
 * Represents a hand of cards
 *
 * @author Michael Kha
 */
public class Hand extends CardHolder {

    /**
     * Create a starting hand to be an empty list of cards.
     */
    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Add the given card to the hand.
     * @param card  Card to add to the hand
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove the specified card from the hand.
     * @param card  Card top remove
     */
    public void remove(Card card) {
        cards.remove(card);
    }

    /**
     * Check if the hand's size is 13.
     * @return  If the hand is full
     */
    public boolean isFull() {
        return cards.size() == 13;
    }

}
