package com.thirteen.model;

import java.util.ArrayList;
import java.util.Comparator;
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
     * The highest value card within the move.
     */
    private Card highCard;

    /**
     * Create a move consisting of a list of cards.
     * For the purposes of ranking moves cards are sorted when a move is made.
     * @param cards List of cards that compose a move.
     */
    public Move(List<Card> cards) {
        cards.sort(Comparator.naturalOrder());
        this.cards = cards;
        highCard = cards.isEmpty() ? null : cards.get(cards.size() - 1);
        play = determinePlay();
    }

    /**
     * TODO: test heavily
     * @return
     */
    public Play determinePlay() {
        // Same some time by not needing to keep checking the size
        switch (cards.size()) {
            case 0:
                return Play.PASS;
            case 1:
                return Play.SINGLE;
            case 2:
                return allCardsSameRank(cards) ? Play.PAIR : Play.ILLEGAL;
            case 3:
                return allCardsSameRank(cards) ? Play.TRIPLE :
                        !containsRank(Rank.TWO) ?
                            allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            Play.ILLEGAL :
                        Play.ILLEGAL;

            case 4:
                return allCardsSameRank(cards) ? Play.FOUR_OF_A_KIND :
                        !containsRank(Rank.TWO) ?
                            allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            Play.ILLEGAL :
                        Play.ILLEGAL;
            case 5:
            case 7:
            case 11:
            case 13:
                return !containsRank(Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            Play.ILLEGAL :
                        Play.ILLEGAL;
            case 6:
            case 8:
            case 10:
                return !containsRank(Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            allPairsConsecutiveRank() ? Play.DOUBLE_SEQUENCE :
                            Play.ILLEGAL :
                        Play.ILLEGAL;
            case 9:
                return !containsRank(Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            allTriplesConsecutiveRank() ? Play.TRIPLE_SEQUENCE :
                            Play.ILLEGAL :
                        Play.ILLEGAL;
            case 12:
                return !containsRank(Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            allPairsConsecutiveRank() ? Play.DOUBLE_SEQUENCE :
                                allTriplesConsecutiveRank() ? Play.TRIPLE_SEQUENCE :
                                Play.ILLEGAL :
                        Play.ILLEGAL;
            default:
                return Play.ILLEGAL;
        }
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
     *
     * @return
     */
    public boolean allCardsSameRank(List<Card> cards) {
        for (int i=0; i<cards.size(); i++) {
            for (int j=i+1; j<cards.size(); j++) {
                if (!cards.get(i).isSameRank(cards.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * preconditions: cards are in order and size is greater than 1.
     * @return
     */
    public boolean allCardsConsecutiveRank(List<Card> cards) {
        // Initialize to the first card in the list
        int checkCounter = cards.get(0).getRankOrdinal();
        for (int i=1; i<cards.size(); i++) {
            if (checkCounter+1 != cards.get(i).getRankOrdinal()) {
                return false;
            }
            checkCounter++;
        }
        return true;
    }

    /**
     *
     * preconditions: cards are in order, even number of cards
     * @return
     */
    public boolean allPairsConsecutiveRank() {
        return allPartitionsConsecutiveRank(2);
    }

    public boolean allTriplesConsecutiveRank() {
        return allPartitionsConsecutiveRank(3);
    }

    /**
     *
     * preconditions: cards are in order
     * @return
     */
    public boolean allPartitionsConsecutiveRank(int size) {
        List<List<Card>> partitions = partitionTo(size);
        int checkCounter = cards.get(0).getRankOrdinal();
        boolean isFirstPartition = true;
        for (List<Card> part : partitions) {
            if (!allCardsSameRank(part)) {
                return false;
            }
            if (!isFirstPartition) {
                if (checkCounter+1 != part.get(0).getRankOrdinal()) {
                    return false;
                }
            } else {
                isFirstPartition = false;
            }
            checkCounter++;
        }
        return true;
    }

    /**
     *
     * preconditions:
     * @return
     */
    private List<List<Card>> partitionTo(int size) {
        List<List<Card>> parts = new ArrayList<>();
        int count = 0;
        List<Card> part = null;
        for (Card card : cards) {
            int mod = count % size;
            if (mod == 0) {
                part = new ArrayList<>();
                part.add(card);
            } else {
                part.add(card);
                if (mod == size-1) {
                    parts.add(part);
                }
            }
            count++;
        }
        return parts;
    }

    /**
     * Check if the cards in the move contain a specific rank.
     * @param rank  Rank to check for
     * @return  If the cards contain the specified rank
     */
    public boolean containsRank(Rank rank) {
        for (Card card : cards) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
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
