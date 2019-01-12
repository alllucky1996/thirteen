package com.thirteen.model;

/**
 * Represents the different types of moves that can be made.
 *
 * @author Michael Kha
 */
public enum Play {
    /**
     * Default type indicating a move is illegal.
     */
    ILLEGAL("Illegal"),
    /**
     * A pass is defined as not playing any cards.
     */
    PASS("Pass"),
    /**
     * From lowest to highest value in terms of only plays(without ties).
     * A sequence is synonymous to a straight. A double sequence is a
     * straight containing pairs of the same rank.
     * Sequences cannot contain two's.
     */
    SINGLE("Single"),
    PAIR("Pair"),
    TRIPLE("Triple"),
    FOUR_OF_A_KIND("Four of a Kind"),//beats any single 2
    SEQUENCE("Sequence"),
    DOUBLE_SEQUENCE("Sequence of Pairs"),//sequence of 4 pairs beats pair of twos, sequence of 5 pairs beats 3 twos
    /**
     * Bombs beat out the above.
     * The following are bombs.
     */
    TRIPLE_SEQUENCE("Sequence of Triples"),
    /**
     * Instant wins
     */
    DRAGON("Dragon"),
    FOUR_TWOS("Four of a Kind, Twos");

    /**
     * Name of the play
     */
    private final String name;

    /**
     * Create a play with a name.
     * @param name  Name to give
     */
    Play(String name) {
        this.name = name;
    }

    /**
     * Get the name of the play.
     * @return  Name of the play
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the name of the play.
     * @return  Name of the play
     */
    @Override
    public String toString() {
        return getName();
    }

}
