package com.thirteen.model;

import java.util.ArrayList;
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
    private Card highCard;

    /**
     * Create a move consisting of a list of cards.
     * For the purposes of ranking moves cards are sorted when a move is made.
     * @param cards List of cards that compose a move.
     */
    public Move(List<Card> cards) {
        cards.sort(Comparator.naturalOrder());
        this.cards = cards;
        highCard = cards.get(cards.size() - 1);
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
            case 10:
                return !containsRank(Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                            allPairsConsecutiveRank() ? Play.DOUBLE_SEQUENCE :
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
     * TODO: remove?
     * TODO: decide to use a list or just use null
     * A pass is a move defined with having no cards being played.
     * @return  If the list of cards is empty.
     */
    public boolean isPass() {
        return isEmpty();
    }

    /**
     * TODO: remove?
     * @return
     */
    public boolean isSingle() {
        return compareSize(1);
    }

    /**
     * TODO: remove?
     * @return
     */
    public boolean isPair() {
        return compareSize(2) && allCardsSameRank(cards);
    }

    /**
     * TODO: remove?
     * @return
     */
    public boolean isTriple() {
        return compareSize(3) && allCardsSameRank(cards);
    }

    /**
     * Helper method
     * @param expected
     * @return
     */
    public boolean compareSize(int expected) {
        return expected == size();
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
        /*
        List<Card[]> pairs = partitionToPairs();
        int checkCounter = cards.get(0).getRankOrdinal();
        boolean isFirstPair = true;
        for (Card[] pair : pairs) {
            if (!pair[0].isSameRank(pair[1])) {
                return false;
            }
            if (!isFirstPair) {
                if (checkCounter+1 != pair[0].getRankOrdinal()) {
                    return false;
                }
            } else {
                isFirstPair = false;
            }
            checkCounter++;
        }
        return true;
        */
    }

    public boolean allTriplesConsecutiveRank() {
        return allPartitionsConsecutiveRank(3);
    }

    /**
     * TODO: delete
     * preconditions: even number of cards
     * @return
     */
    private List<Card[]> partitionToPairs() {
        List<Card[]> pairs = new ArrayList<>();
        int count = 0;
        Card[] cardArray = new Card[2];
        for (Card card : cards) {
            if (count % 2 == 1) {
                cardArray[1] = card;
                pairs.add(cardArray);
            } else {
                cardArray[0] = card;
            }
            count++;
        }
        return pairs;
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
    /*
    private List<Card[]> partitionTo(int size) {
        List<Card[]> parts = new ArrayList<>();
        int count = 0;
        Card[] cardArray = new Card[size];
        for (Card card : cards) {
            int mod = count % size;
            if (mod == 2) {
                cardArray[mod] = card;
                parts.add(cardArray);
            } else {
                cardArray[mod] = card;
            }
            count++;
        }
        return parts;
    }*/
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
     * Compare
     * @param other
     * @return
     */
    @Override
    public int compareTo(Move other) {

        return 0;
    }
}
