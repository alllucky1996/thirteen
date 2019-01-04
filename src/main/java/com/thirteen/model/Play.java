package com.thirteen.model;

/**
 * Represents the different types of moves that can be made.
 *
 * @author Michael Kha
 */
public enum Play {
    //TODO: determine all possible combinations
    /**
     * From lowest to highest value in terms of only plays(without ties).
     * A sequence is synonymous to a straight. A double sequence is a
     * straight containing pairs of the same rank.
     * Sequences cannot contain two's.
     */
    SINGLE,
    PAIR,
    TRIPLE,
    FOUR_OF_A_KIND,
    SEQUENCE,
    DOUBLE_SEQUENCE,
    /**
     * Bombs and twos beat out the above.
     */
}
