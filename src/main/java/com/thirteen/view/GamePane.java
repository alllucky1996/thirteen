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

public class GamePane extends BorderPane implements CardView {

    GamePane() {
        // Set up the bottom of the game pane: displaying cards in hand and UI
        BorderPane bottom = new BorderPane();
        // The player's hand showing their cards
        HBox handPane = new HandPane(createHand());
        ThirteenView.setDefSize(handPane, CARD_WIDTH / 5 * 13, CARD_HEIGHT / 5);
        handPane.setAlignment(Pos.BOTTOM_LEFT);
        // The player's user interface
        GridPane playerPane = new PlayerPane("A name!");
        playerPane.setAlignment(Pos.BOTTOM_RIGHT);
        // Set the left and right of the bottom pane
        bottom.setLeft(handPane);
        bottom.setRight(playerPane);
        // Add to the bottom of the game pane
        setBottom(bottom);

        // Set up the center of the game pane: displaying opponent hands
        Pane tablePane = new TablePane(createHand(), createHand(), createHand());
        setCenter(tablePane);

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
