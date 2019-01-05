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

}
