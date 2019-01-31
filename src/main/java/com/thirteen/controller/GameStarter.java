package com.thirteen.controller;

import com.thirteen.model.Game;
import com.thirteen.model.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main point of access to start a game.
 *
 * @author Michael Kha
 */
public class GameStarter {

    /**
     * Used to keep track of games and the controllers managing the games.
     */
    private Map<Game, GameManager> gameManagement;

    /**
     * Create a game starter.
     */
    public GameStarter() {
        gameManagement = new HashMap<>();
    }

    /**
     * Start a game with the given players.
     * @param players   Players to place into a game
     * @return  The game created
     */
    public Game startGame(List<Player> players) throws GameException {
        if (!(players.size() > 0 && players.size() <= 4)) {
            throw new GameException("illegal number of players");
        }
        Game game = new Game(players);
        GameManager gameManager = new GameManager(game);
        gameManagement.put(game, gameManager);
        return game;
    }

}
