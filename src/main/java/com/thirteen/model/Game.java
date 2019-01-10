package com.thirteen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Represents a game of Thirteen(Tiến lên), a Vietnamese card game.
 * Similar to the game of UNO but with playing cards and some other rules.
 * All rules are based on personal experience and information taken from
 * Wikipedia.
 *
 * @author Michael Kha
 */
public class Game extends WinnerTool {

    /**
     * The deck of cards
     */
    private Deck deck;

    /**
     * Players within the game
     */
    private List<Player> players;

    /**
     * The rounds played in this game
     */
    private List<Round> rounds;

    /**
     * TODO: remove: responsibility delegated elsewhere
     * Current player whose turn it is
     */
    private Player currentPlayer;

    /**
     * TODO: remove field
     * Track the last turn
     */
    private Turn lastTurn;

    /**
     * Create a new game with two to four players.
     * @param numPlayers    Number of players (2-4)
     */
    public Game(int numPlayers) {
        deck = new Deck(new Stack<>());
        players = new ArrayList<>();
        rounds = new ArrayList<>();
        for (int i=0; i<numPlayers; i++) {
            players.add(new Player());
        }
    }

    /**
     * TODO: called by controller
     * Start the game by dealing cards to all players
     * and setting the current player's turn to the person with
     * a Three of Spades or the lowest value card (when there are less
     * than four players).
     */
    public void init() {
        // Currently hard coded for 4 players only
        while (!players.get(0).isHandFull()) {
            for (Player player : players) {
                Card card = dealFromDeck();
                if (card.isRankAndSuit(Rank.THREE, Suit.SPADES)) {
                    currentPlayer = player;
                }
                player.addToHand(card);
            }
        }
        // TODO: Deck should be empty (test this)
    }

    /**
     *
     *
     */
    public void start() {
        Round round;
        while (!hasWinner()) {
            // Start a new round
            round = new Round(players, new ArrayList<>(), currentPlayer);
            rounds.add(round);
        }
    }

    /**
     *
     * preconditions: current player has been updated
     * @return
     */
    public Round createRound() {
        return new Round(players, new ArrayList<>(), currentPlayer);
    }

    /**
     * Update the current player to the last round's winner.
     * @return  The next current player
     */
    public Player updateCurrentPlayer() {
        Round round = getLastRound();
        currentPlayer = round.getCurrent();
        currentPlayer = getLastRound().getWinner();
        return currentPlayer;
    }

    public Round getLastRound() {
        int size = rounds.size();
        return size == 0 ? null : rounds.get(size - 1);
    }

    /**
     * TODO: called by controller
     * preconditions: deck is not empty; if empty take discard pile and shuffle into deck
     * @return
     */
    public Card dealFromDeck() {
        return deck.dealACard();
    }

    /**
     * TODO: called by controller
     * preconditions: start of game or discard pile added to deck
     */
    public void shuffleDeck() {
        deck.shuffle();
    }

    /**
     * Determine if a winner exists by looking at each player's hand
     * and seeing if other players have passed.
     * @return  If a winner can be declared for this round
     */
    public boolean doesWinnerExist() {
        if (hasWinner()) {
            return true;
        }
        // Compare player with other players
        for (Player player : players) {
            for (Player other : players) {
                if (player != other) {
                    if (player.isHandEmpty() && !other.isHandEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Round> getRounds() {
        return rounds;
    }

}
