package com.thirteen.model;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a move made in the game consisting of a collection of cards.
 * The validity/legality of a move is dependent on the previous turn's move
 *
 * @author Michael Kha
 */
public class Move extends CardHolder implements Comparable<Move> {

    /**
     * The type of play this move is
     */
    private Play play;

    /**
     * The highest value card within the move.
     */
    private Card highestValue;

    /**
     * Create a move consisting of a list of cards.
     * For the purposes of ranking moves cards are sorted when a move is made.
     * @param cards List of cards that compose a move.
     */
    public Move(List<Card> cards) {
        cards.sort(Comparator.naturalOrder());
        this.cards = cards;
        highestValue = cards.get(cards.size() - 1);
    }

    /**
     * Get the highest value card in the move.
     * @return  Get the highestValued value card
     */
    public Card getHighestValue() {
        return highestValue;
    }

    /**
     * Compare the highest value card to another card.
     * Used for comparing with another highest value card in another move.
     * @param other
     * @return
     */
    public int compareHighestValue(Card other) {
        return highestValue.compareTo(other);
    }

    /**
     * TODO: decide to use a list or just use null
     * A pass is a move defined with having no cards being played.
     * @return  If the list of cards is empty.
     */
    public boolean isPass() {
        return isEmpty();
    }

    /**
     * Compare
     * @param other
     * @return
     */
    @Override
    public int compareTo(Move other) {

        return 0;
    }
}
