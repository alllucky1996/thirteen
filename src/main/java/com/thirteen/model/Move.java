package com.thirteen.model;

import java.util.List;

/**
 * Represents a move made in the game consisting of a collection of cards.
 * The validity/legality of a move is dependent on the previous turn's move.
 * TODO: clean up class
 *
 * @author Michael Kha
 */
public class Move extends CardHolder implements Comparable<Move> {

    /**
     * The type of play this move is
     */
    private Play play;

    /**
     * The highest value card within the move
     */
    private Card highCard;

    /**
     * Create a move consisting of a list of cards.
     * For the purposes of ranking moves cards are sorted when a move is made.
     * @param cards List of cards that compose a move.
     */
    public Move(List<Card> cards) {
        this.cards = cards;
        highCard = cards.isEmpty() ? null : cards.get(cards.size() - 1);
        play = MoveEvaluator.determinePlay(cards);
    }

    /**
     * Get the type of play this move is.
     * @return
     */
    public Play getPlay() {
        return play;
    }

    /**
     * Get the highest value card in the move.
     * @return  Get the highestValued value card
     */
    public Card getHighCard() {
        return highCard;
    }

    /**
     * Compare the highest value card to another card.
     * Used for comparing with another highest value card in another move.
     * @param other
     * @return
     */
    public int compareHighestValue(Card other) {
        return highCard.compareTo(other);
    }

    /**
     * Compare this move to another move. First compare the plays
     * and if the plays are equal, then compare the high cards.
     * @param other Other move to compare with
     * @return  If this move is less than, equal to, or greater than
     *          return -1, 0, or 1.
     */
    @Override
    public int compareTo(Move other) {
        int playCompare = play.compareTo(other.play);
        return playCompare != 0 ? playCompare :
                play == Play.PASS && other.play == Play.PASS ? 0 :
                highCard.compareTo(other.highCard);
    }

}
