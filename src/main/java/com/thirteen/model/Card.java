package com.thirteen.model;

/**
 * Represents a single card in a typical 52-card deck.
 *
 * @author Michael Kha
 */
public class Card {

    /**
     * Suit of this card
     */
    private Suit suit;

    /**
     * Rank of this card
     */
    private Rank rank;

    /**
     * Create a card with no suit or rank.
     * Used to represent a Joker.
     */
    public Card() {
        this.suit = null;
        this.rank = null;
    }

    /**
     * Create a card with a given suit and rank.
     * @param suit  Suit of this card
     * @param rank  Rank of this card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Get the suit of this card.
     * @return  Suit of this card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get the rank of this card.
     * @return  Rank of this card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Check if another object is equal to this card.
     * Equal is defined as having the same suit and rank.
     * @param obj   Object to check
     * @return  If the object is equal to this card
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Card) {
            Card other = (Card)obj;
            return suit == other.suit && rank == other.rank;
        }
        return false;
    }

    /**
     * String representation of the card as you would say it normally
     * such as "Ace of Spades"
     * @return  String in the form of "Rank of Suit"
     */
    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
