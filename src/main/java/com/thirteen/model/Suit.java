package com.thirteen.model;

/**
 * Represents the different suits used in playing cards.
 *
 * @author Michael Kha
 */
public enum Suit {
    SPADES,
    CLUBS,
    DIAMONDS,
    HEARTS;

    /**
     * TODO: remove and use ordinal()
     * Evaluate the value of the suit to an integer.
     * @param suit  Suit to evaluate
     * @return  Integer value of the suit
     */
    public static int evaluate(Suit suit) {
        switch (suit) {
            case HEARTS:
                return 4;
            case DIAMONDS:
                return 3;
            case CLUBS:
                return 2;
            case SPADES:
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Replaces the original enum's to string to only have the first letter
     * capitalized.
     * @return  String with only the first letter capitalized
     */
    @Override
    public String toString() {
        String original = super.toString();
        return original.substring(0, 1) + original.substring(1).toLowerCase();
    }
}
