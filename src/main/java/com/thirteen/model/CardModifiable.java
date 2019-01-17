package com.thirteen.model;

import java.util.List;

/**
 * Interface to be used for any class that holds a list of type Card and
 * wants additional modification behavior.
 *
 * @author Michael Kha
 */
public interface CardModifiable {

    /**
     * Add the given card to the list of cards.
     * @param card  Card to add
     */
    void add(Card card);

    /**
     * Remove the specified card from the list of cards.
     * @param card  Card to remove
     */
    void remove(Card card);

    /**
     * Clear all cards in the list of cards.
     */
    void clear();

    /**
     * Appends all of the cards in the specified list to the end of this list.
     * @param cards  List containing elements to be added to this list
     */
    void addAll(List<Card> cards);

}
