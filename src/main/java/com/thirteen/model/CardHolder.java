package com.thirteen.model;

import java.util.List;

/**
 * Concrete implementation of the CardStructure interface. Holds a
 * list of cards to be used by subclasses.
 * Abstract class to be extended by another class. Behavior is defined
 * in this class as well as the state to be inherited by subclasses.
 *
 * @author Michael Kha
 */
public abstract class CardHolder implements CardStructure {

    /**
     * Cards that are currently being held
     */
    List<Card> cards;

    /**
     * Get the cards in the structure.
     * @return  List of type Card
     */
    @Override
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Get the number of cards in the list.
     * @return  The size of the list of cards
     */
    @Override
    public int size() {
        return cards.size();
    }

    /**
     * If there are no more cards in the list.
     * @return  Is the list empty?
     */
    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
