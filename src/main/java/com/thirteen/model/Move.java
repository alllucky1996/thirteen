package com.thirteen.model;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a move made in the game consisting of a collection of cards.
 * The validity/legality of a move is dependent on the previous turn's move.
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
        cards.sort(Comparator.naturalOrder());
        play = MoveEvaluator.determinePlay(cards);
        highCard = cards.isEmpty() || play == Play.ILLEGAL ? null :
                cards.get(cards.size() - 1);
    }

    /**
     * Get the type of play this move is.
     * @return  The play
     */
    public Play getPlay() {
        return play;
    }

    /**
     * Get the highest value card in the move.
     * @return  The highestValued value card
     */
    public Card getHighCard() {
        return highCard;
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
        int playCompare = play.convertCompareTo(other.play);
        return playCompare != 0 ? playCompare :
                play == Play.ILLEGAL ? -1 : other.play == Play.ILLEGAL ? 1 :
                play == Play.PASS && other.play == Play.PASS ? 0 :
                highCard.compareTo(other.highCard);
    }

}
