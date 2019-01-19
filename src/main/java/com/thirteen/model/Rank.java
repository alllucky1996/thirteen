package com.thirteen.model;

/**
 * Represents the different ranks used in playing cards.
 *
 * @author Michael Kha
 */
public enum Rank {
    BACK,
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
     * Replaces the original enum's to string to only have the first letter
     * capitalized.
     * @return  String with only the first letter capitalized
     */
    @Override
    public String toString() {
        String original = super.toString();
        return original.substring(0, 1) + original.substring(1).toLowerCase();
    }

    /**
     * Convert the enum compareTo method to return -1, 0, or 1.
     * @return  The integer comparison of the enum compare
     */
    public int convertCompareTo(Rank other) {
        int compare = compareTo(other);
        return Integer.compare(compare, 0);
    }

}
