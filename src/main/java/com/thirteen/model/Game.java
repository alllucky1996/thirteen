package com.thirteen.model;

import java.util.Stack;

/**
 * Represents a game of Thirteen(Tiến lên), a Vietnamese card game.
 * Similar to the game of UNO but with playing cards and some other rules.
 * All rules are based on personal experience and information taken from
 * Wikipedia.
 *
 * @author Michael Kha
 */
public class Game {

    /**
     * Players within the game
     */
    private Player[] players;

    /**
     * The deck of cards
     */
    private Deck deck;

    /**
     * Current player whose turn it is
     */
    private Player currentPlayer;

    /**
     *
     */
    private Turn lastTurn;

    /**
     * Create a new game with four players.
     * @param numPlayers    Number of players (2-4)
     * @return
     */
    public Game(int numPlayers) {
        deck = new Deck(new Stack<>());
        players = new Player[numPlayers];
        for (int i=0; i<players.length; i++) {
            players[i] = new Player();
        }
    }

    /**
     * Create a game
     * @param players   Players to start a game with
     */
    public Game(Player[] players) throws Exception {
        if (!(players.length >= 2 && players.length <= 4)) {
            throw new Exception();
        }
        this.players = players;
    }

    /**
     *
     * preconditions: deck is not empty; if empty take discard pile and shuffle into deck
     * @return
     */
    public Card dealFromDeck() {
        return deck.dealACard();
    }

    /**
     *
     * preconditions: start of game or discard pile added to deck
     */
    public void shuffleDeck() {
        deck.shuffle();
    }

}
