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
     * Pile that holds played cards
     */
    private Pile discardPile;

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
        discardPile = new Pile(new Stack<>());
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }
    }

    /**
     * Create a new game from given players.
     * Number of players must be 2-4.
     * @param players   2-4 players
     */
    public Game(List<Player> players) {
        deck = new Deck(new Stack<>());
        this.players = players;
        rounds = new ArrayList<>();
    }

    /**
     * Reset the game to a new game using the discard pile.
     */
    public void reset() {
        if (isGameOver()) {
            // Clear all hands
            for (Player player : players) {
                if (!player.isHandEmpty()) {
                    discardPile.addAll(player.getCardsInHand());
                    player.clearHand();
                }
            }
            // Add cards back from discard pile
            deck.addAll(discardPile);
            // Reset discard pile
            discardPile.clear();
            // Start the game over
            start();
        }
    }

    /**
     * First shuffles the deck.
     * Start the game by dealing cards to all players
     * and setting the current player's turn to the person with
     * a Three of Spades or the lowest value card (when there are less
     * than four players).
     */
    public void start() {
        deck.shuffle();
        Player starting = players.get(0);
        while (!players.get(0).isHandFull()) {
            for (Player player : players) {
                Card card = deck.dealACard();
                if (card.isRankAndSuit(Rank.THREE, Suit.SPADES)) {
                    starting = player;
                }
                player.addToHand(card);
            }
        }
        rounds.add(createRound(starting));
    }

    /**
     * Make a move given a list of cards. A move is created and checked.
     * A turn is then created for the current round. The round then determines
     * if the player making the move can legally submit the turn.
     * @return If the game successfully created a move and added it to the
     *         round's turn
     */
    public boolean makeMove(List<Card> cards) {
        Move move = new Move(cards);
        if (move.isPlay(Play.ILLEGAL)) {
            return false;
        }
        Round current = getCurrentRound();
        Turn turn = current.createTurn(move);
        return current.addTurn(turn);
    }

    /**
     * Create a new round using a starting player
     * @param starting  Starting player of the new round
     * @return A new round
     */
    private Round createRound(Player starting) {
        return new Round(players, new ArrayList<>(), discardPile, starting);
    }

    /**
     * Get the current round if it exists.
     * @return  The current round
     */
    public Round getCurrentRound() {
        int size = rounds.size();
        return size == 0 ? null : rounds.get(size - 1);
    }

    /**
     * TODO: see if needed
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

    /**
     * Determine if the game has reached completion. This is indicated when
     * only one player still has cards.
     * @return  If the game is over
     */
    public boolean isGameOver() {
        int count = 0;
        for (Player player : players) {
            if (player.isHandEmpty()) {
                count++;
            }
        }
        return count == players.size() - 1;
    }

    /**
     * Get the players in the game.
     * @return  The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * TODO: remove?
     * Get the deck used in the game.
     * @return  The deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Get the discard pile.
     * @return  The discard pile
     */
    public Pile getDiscardPile() {
        return discardPile;
    }

    /**
     * Get the current player based on the current round.
     * @return  The current player
     */
    public Player getCurrentPlayer() {
        return getCurrentRound().getCurrent();
    }

    /**
     * Get the rounds played in the game.
     * @return  The rounds that have been played
     */
    public List<Round> getRounds() {
        return rounds;
    }

}
