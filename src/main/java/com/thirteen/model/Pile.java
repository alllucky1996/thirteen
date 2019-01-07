package com.thirteen.model;

import java.util.List;

/**
 * Represents a pile of cards that have been played.
 *
 * @author Michael Kha
 */
public class Pile extends CardUpdater {

    /**
     * Create a pile of cards.
     * @param cards List of cards to refer to as the pile
     */
    public Pile(List<Card> cards) {
        this.cards = cards;
    }

}
