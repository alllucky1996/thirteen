package com.thirteen.model;

/**
 * TODO: make enum possibly
 * TODO: document
 */
public class CardID {

    private Rank rank;

    private Suit suit;

    public CardID(Rank rank ,Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int hashCode() {
        return rank.hashCode() * 31 + suit.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CardID) {
            CardID o = (CardID) other;
            return rank == o.rank && suit == o.suit;
        }
        return false;
    }

}
