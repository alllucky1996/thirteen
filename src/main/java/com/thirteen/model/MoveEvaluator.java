package com.thirteen.model;

/**
 * Evaluate the move made on a turn for evaluation of legality and value.
 * Compares the move to be made with the last move made. If the move is a bomb
 * further evaluation is continued in BombEvaluator.
 * This class is a static class using a final class declaration, private
 * constructor, and static methods.
 *
 * @author Michael Kha
 */
public final class MoveEvaluator {

    private MoveEvaluator() {

    }

    /**
     * If the
     * @param lastMove
     * @param moveToMake
     * @return
     */
    public static boolean isValid(Move lastMove, Move moveToMake) {
        return true;
    }

    /**
     * TODO: make TWO overrule all previous moves
     * TODO: use compareTo function in Move-
     * @param lastMove
     * @param moveToMake
     * @return
     */
    public static boolean compareMove(Move lastMove, Move moveToMake) {
        // Can simplify return statement
        int last = evaluateMove(lastMove);
        int next = evaluateMove(moveToMake);
        return next > last;
    }

    /**
     *
     * TODO: use compareTo function in Move
     * @return
     */
    public static boolean compareRank() {
        return true;
    }

    /**
     *
     * @return
     */
    public static boolean isSequence() {
        return true;
    }

    /**
     * The only way to beat single twos or sets of twos is to have
     * these combinations.
     * @return
     */
    public static boolean isBomb() {
        return true;
    }

    /**
     * TODO: refactor into Move class POSSIBLY
     * @param move
     * @return
     */
    public static int evaluateMove(Move move) {
        return 0;
    }

    /**
     * TODO: refactor into Card class
     * @param card
     * @return
     */
    public static int evaluateCard(Card card) {
        return 0;
    }

    /**
     * TODO: refactor into Rank enum
     * @param rank
     * @return
     */
    public static int evaluateRank(Rank rank) {
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
     * TODO: refactor into Suit enum
     * @param suit
     * @return
     */
    public static int evaluateSuit(Suit suit) {
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
}
