package com.thirteen.model;

import java.util.List;

/**
 * Interface to be used for any class that holds a list of type Card.
 * Defines expected behavior that a card related structure will need.
 *
 * @author Michael Kha
 */
public interface CardStructure {

    /**
     * Get the cards in the structure.
     * @return  List of type Card
     */
    List<Card> getCards();

    /**
     * Get the number of cards in the list.
     * @return  The size of the list of cards
     */
    int size();

    /**
     * If there are no more cards in the list
     * @return  Is the list empty?
     */
    boolean isEmpty();

    /**
     * Appends all of the cards in the specified list to the end of this list.
     * @param cards  List containing elements to be added to this list
     */
    void addAll(List<Card> cards);

}
