package com.thirteen.model;

/**
 * Represents the different types of moves that can be made.
 *
 * @author Michael Kha
 */
public enum Play {
    //TODO: determine all possible combinations
    /**
     * Default type indicating a move is illegal.
     */
    ILLEGAL,
    /**
     * A pass is defined as not playing any cards.
     */
    PASS,
    /**
     * From lowest to highest value in terms of only plays(without ties).
     * A sequence is synonymous to a straight. A double sequence is a
     * straight containing pairs of the same rank.
     * Sequences cannot contain two's.
     */
    SINGLE,
    PAIR,
    TRIPLE,
    FOUR_OF_A_KIND,//beats any single 2
    SEQUENCE,
    DOUBLE_SEQUENCE,//sequence of 4 pairs beats pair of twos, sequence of 5 pairs beats 3 twos
    /**
     * TODO: fill in
     * Bombs beat out the above.
     * The following are bombs.
     */
    TRIPLE_SEQUENCE,
    /**
     * Instant wins
     */
    DRAGON,
    FOUR_TWOS



}
