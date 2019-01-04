package com.thirteen.model;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents a typical deck of cards. Can also represent
 * a deck of cards including Jokers.
 *
 * @author Michael Kha
 */
public class Deck extends CardHolder {

    /**
     * Number of Jokers to add to a deck
     */
    private static final int NUM_JOKERS = 2;

    /**
     * Create a standard 52-card deck.
     */
    public Deck(List<Card> cards) {
        this(cards, false);
    }

    /**
     * Create a deck with a given number of cards.
     * @param addJoker  If this deck will include jokers.
     */
    public Deck(List<Card> cards, boolean addJoker) {
        this.cards = cards;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        if (addJoker) {
            int currentAmount = 0;
            while (currentAmount < NUM_JOKERS) {
                cards.add(new Card());
                currentAmount++;
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
