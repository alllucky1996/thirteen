package com.thirteen.model;

import java.util.List;

/**
 * Represents a storage of cards.
 *
 * @author Michael Kha
 */
public class Storage extends CardHolder {

    /**
     * Create a storage of cards.
     * @param cards List of cards to refer to as the pile
     */
    public Storage(List<Card> cards) {
        this.cards = cards;
    }

}
