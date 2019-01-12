package com.thirteen.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Evaluate a move by determining the type of play it is.
 * Static class.
 *
 * @author Michael Kha
 */
public final class MoveEvaluator {

    /**
     * Private constructor to stop instantiation.
     */
    private MoveEvaluator() {

    }

    /**
     * TODO: test heavily
     * Determines the type of play given a list of cards.
     * @param cards List of cards
     * @return  The play the cards represent
     */
    static Play determinePlay(List<Card> cards) {
        // First sort the cards
        cards.sort(Comparator.naturalOrder());
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
                        !containsRank(cards, Rank.TWO) ?
                                allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                        Play.ILLEGAL :
                                Play.ILLEGAL;

            case 4:
                return allCardsSameRank(cards) ? Play.FOUR_OF_A_KIND :
                        !containsRank(cards, Rank.TWO) ?
                                allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                        Play.ILLEGAL :
                                Play.ILLEGAL;
            case 5:
            case 7:
            case 11:
            case 13:
                return !containsRank(cards, Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                Play.ILLEGAL :
                        Play.ILLEGAL;
            case 6:
            case 8:
            case 10:
                return !containsRank(cards, Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                allPairsConsecutiveRank(cards) ? Play.DOUBLE_SEQUENCE :
                                        Play.ILLEGAL :
                        Play.ILLEGAL;
            case 9:
                return !containsRank(cards, Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                allTriplesConsecutiveRank(cards) ? Play.TRIPLE_SEQUENCE :
                                        Play.ILLEGAL :
                        Play.ILLEGAL;
            case 12:
                return !containsRank(cards, Rank.TWO) ?
                        allCardsConsecutiveRank(cards) ? Play.SEQUENCE :
                                allPairsConsecutiveRank(cards) ? Play.DOUBLE_SEQUENCE :
                                        allTriplesConsecutiveRank(cards) ? Play.TRIPLE_SEQUENCE :
                                                Play.ILLEGAL :
                        Play.ILLEGAL;
            default:
                return Play.ILLEGAL;
        }
    }

    /**
     * Are all the cards the same rank?
     * @param cards List of cards
     * @return  If all the cards have the same rank
     */
    private static boolean allCardsSameRank(List<Card> cards) {
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
     * Are the cards consecutively ranked?
     * preconditions: cards are in order and size is greater than 1.
     * @param cards List of cards
     * @return  If the cards are consecutively ranked
     */
    private static boolean allCardsConsecutiveRank(List<Card> cards) {
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
     * Are the cards in pairs and consecutively ranked?
     * preconditions: cards are in order, even number of cards
     * @param cards List of cards
     * @return  If the card pairs are consecutively ranked
     */
    private static boolean allPairsConsecutiveRank(List<Card> cards) {
        return allPartitionsConsecutiveRank(cards, 2);
    }

    /**
     * Are the cards in triples and consecutively ranked?
     * @param cards List of cards
     * @return  If the card triples are consecutively ranked
     */
    private static boolean allTriplesConsecutiveRank(List<Card> cards) {
        return allPartitionsConsecutiveRank(cards,3);
    }

    /**
     * Are all partitions of some size consecutively ranked?
     * preconditions: cards are in order
     * @param cards List of cards
     * @return  If the card partitions are consecutively ranked
     */
    private static boolean allPartitionsConsecutiveRank(List<Card> cards, int size) {
        List<List<Card>> partitions = partitionTo(cards, size);
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
     * Partition a list of cards into a list of partitions of cards of
     * a given size.
     * @param cards List of cards
     * @param size  Size of partitions
     * @return  List of partitions of cards
     */
    private static List<List<Card>> partitionTo(List<Card> cards, int size) {
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
     * @param cards List of cards to look through
     * @param rank  Rank to check for
     * @return  If the cards contain the specified rank
     */
    static boolean containsRank(List<Card> cards, Rank rank) {
        for (Card card : cards) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

}
