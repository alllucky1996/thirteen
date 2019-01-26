package com.thirteen.view;

import com.thirteen.model.Deck;
import com.thirteen.model.Hand;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A border pane representing the main game screen.
 *
 * @author Michael Kha
 */
public class GamePane extends BorderPane implements CardView, ThirteenView {

    /**
     * Create the game pane by creating the hand pane, player pane,
     * and table pane.
     * @param playerName    The name of the player
     */
    GamePane(String playerName) {
        // Set up the bottom of the game pane: displaying cards in hand and UI
        HBox bottom = new HBox();
        // The player's hand showing their cards
        HBox handPane = new HandPane(createHand());
        ThirteenView.setDefSize(handPane,
                CARD_WIDTH / 8.5 * 12 + CARD_WIDTH / 6, CARD_HEIGHT / 6);
        handPane.setAlignment(Pos.BOTTOM_RIGHT);
        // The player's user interface
        GridPane playerPane = new PlayerPane(playerName);
        playerPane.setAlignment(Pos.BOTTOM_RIGHT);
        // Set the left and center of the bottom pane
        bottom.getChildren().addAll(handPane, playerPane);
        // Align bottom toward the center right
        bottom.setAlignment(Pos.CENTER_RIGHT);
        // Add to the bottom of the game pane
        setBottom(bottom);

        // Set up the center of the game pane: displaying opponent hands
        Pane tablePane = new TablePane(createHand(), createHand(), createHand());
        // Add to the center of the game pane
        setCenter(tablePane);

        // TODO: add right UI pane

        //setBackground();

    }

    /**
     * TODO: change to injecting into the constructor's parameter
     * Temporary hand creator
     * @return  A mock hand
     */
    private Hand createHand() {
        Deck deck = new Deck(new Stack<>());
        Hand hand = new Hand(new ArrayList<>());
        while (!hand.isFull()) {
            hand.add(deck.dealACard());
        }
        return hand;
    }

}
