package com.thirteen.model;

import java.util.List;

/**
 * Adds update functionality to the CardHolder class for subclasses that
 * require the use of adding and removing specific cards.
 *
 * @author Michael Kha
 */
public abstract class CardModifier extends CardHolder implements CardModifiable {

    /**
     * Add the given card to the list of cards.
     * @param card  Card to add
     */
    @Override
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove the specified card from the list of cards.
     * @param card  Card to remove
     */
    @Override
    public void remove(Card card) {
        cards.remove(card);
    }

    /**
     * Clear all cards in the list of cards.
     */
    @Override
    public void clear() {
        cards.clear();
    }

    /**
     * Appends all of the cards in the specified list to the end of this list.
     * @param cards  List containing elements to be added to this list
     */
    @Override
    public void addAll(List<Card> cards) {
        this.cards.addAll(cards);
    }

}
