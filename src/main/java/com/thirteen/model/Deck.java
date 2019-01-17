package com.thirteen.model;

import java.util.Collections;
import java.util.List;

/**
 * Represents a typical 52-card deck. Cards can be dealt and
 * shuffled.
 *
 * @author Michael Kha
 */
public class Deck extends Pile {

    /**
     * Create a standard 52-card deck with a given number of cards.
     * @param cards List of cards to refer to as the deck
     */
    public Deck(List<Card> cards) {
        super(cards);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffle the list of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deal a single card from the deck.
     */
    public Card dealACard() {
        return cards.remove(0);
    }

    /**
     * Decks are equal if and only if the number of cards is the same
     * and the cards located at each position within the deck kare equal.
     * @param obj   Object to check
     * @return If the object is equivalent to this deck
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Deck) {
            Deck other = (Deck)obj;
            if (cards.size() != other.cards.size()) {
                return false;
            }
            for (int i=0; i<cards.size(); i++) {
                if (!cards.get(i).equals(other.cards.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
