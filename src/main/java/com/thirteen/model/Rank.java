package com.thirteen.model;

/**
 * Represents the different ranks used in playing cards.
 *
 * @author Michael Kha
 */
public enum Rank {
    ACE,
    KING,
    QUEEN,
    JACK,
    TEN,
    NINE,
    EIGHT,
    SEVEN,
    SIX,
    FIVE,
    FOUR,
    THREE,
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
}
