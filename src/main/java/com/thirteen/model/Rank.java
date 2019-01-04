package com.thirteen.model;

/**
 * Represents the different ranks used in playing cards.
 *
 * @author Michael Kha
 */
public enum Rank {
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE,
    TWO;

    /**
     * TODO: remove and use ordinal()
     * Evaluate the value of the rank to an integer.
     * @param rank  Rank to evaluate
     * @return  Integer value of the rank
     */
    public static int evaluate(Rank rank) {
        switch (rank) {
            case TWO:
                return 13;
            case ACE:
                return 12;
            case KING:
                return 11;
            case QUEEN:
                return 10;
            case JACK:
                return 9;
            case TEN:
                return 8;
            case NINE:
                return 7;
            case EIGHT:
                return 6;
            case SEVEN:
                return 5;
            case SIX:
                return 4;
            case FIVE:
                return 3;
            case FOUR:
                return 2;
            case THREE:
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
