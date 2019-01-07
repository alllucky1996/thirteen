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
    FOUR_TWOS;

    /**
     * Capitalize the first letter in a string and change all other
     * letters to lowercase.
     * @param string    String to perform on
     * @return  Formatted string
     */
    private String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase()
                + string.substring(1).toLowerCase();
    }

    /**
     * Format the enum's string to title case.
     * @return  String in title case format
     */
    @Override
    public String toString() {
        String original = super.toString();
        String[] parts = original.split("_");
        switch (parts.length) {
            case 1:
                return capitalizeFirstLetter(original);
            case 2:
            case 4:
                String s = "";
                for (String part : parts) {
                    if (part.length() > 3) {
                        s += capitalizeFirstLetter(part);
                    } else {
                        s += part.toLowerCase();
                    }
                    if (!part.equals(parts[part.length()-1])) {
                        s += " ";
                    }
                }
                return s;
            default:
                return null;
        }
    }

}
