package com.thirteen.model;

/**
 * Adds update functionality to the CardHolder class for subclasses that
 * require the use of adding and removing specific cards.
 *
 * @author Michael Kha
 */
public abstract class CardUpdater extends CardHolder {

    /**
     * Add the given card to the list of cards.
     * @param card  Card to add
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove the specified card from the list of cards.
     * @param card  Card to remove
     */
    public void remove(Card card) {
        cards.remove(card);
    }

    /**
     * Clear all cards in the list of cards.
     */
    public void clear() {
        cards.clear();
    }

}
