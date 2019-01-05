package com.thirteen.model;

/**
 * Represents a single card in a typical 52-card deck.
 *
 * @author Michael Kha
 */
public class Card implements Comparable<Card> {

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
     * TODO: see if needed
     * Get the ordinal value of the suit.
     * @return  The ordinal value
     */
    public int getSuitOrdinal() {
        return suit.ordinal();
    }

    /**
     * Get the ordinal value of the rank.
     * @return  The ordinal value
     */
    public int getRankOrdinal() {
        return rank.ordinal();
    }

    /**
     * TODO: see if needed
     * Does the given card have the same suit as this card?
     * @param card  Card to check
     * @return  If the suits are the same
     */
    public boolean isSameSuit(Card card) {
        return suit == card.suit;
    }

    /**
     * Does the given card have the same rank as this card?
     * @param card  Card to check
     * @return  If the ranks are the same
     */
    public boolean isSameRank(Card card) {
        return rank == card.rank;
    }

    /**
     * Does this card have the specified rank and suit?
     * @param rank  Rank to check
     * @param suit  Suit to check
     * @return  If both rank and suit are equal
     */
    public boolean isRankAndSuit(Rank rank, Suit suit) {
        return this.rank == rank && this.suit == suit;
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
     * Compare this card to another card. First compare the ranks
     * and if the ranks are equal, then compare the suits.
     * @param other Other card to compare with
     * @return  If this card is less than, equal to, or greater than
     *          return -1, 0, or 1.
     */
    @Override
    public int compareTo(Card other) {
        int rankCompare = rank.compareTo(other.rank);
        return rankCompare == 0 ? suit.compareTo(other.suit) : rankCompare;
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
