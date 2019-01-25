package com.thirteen.view;

import com.thirteen.model.Deck;
import com.thirteen.model.Hand;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Stack;

public class GamePane extends BorderPane implements CardView {

    GamePane() {
        // Set up the bottom of the Game Pane: displaying cards in hand and UI
        BorderPane bottom = new BorderPane();
        HBox handPane = new HandPane(createHand());
        ThirteenView.setDefSize(handPane, CARD_WIDTH / 5 * 13, CARD_HEIGHT / 5);
        handPane.setAlignment(Pos.BOTTOM_LEFT);

        GridPane playerPane = new PlayerPane("A name!");
        playerPane.setAlignment(Pos.BOTTOM_RIGHT);

        bottom.setLeft(handPane);
        bottom.setRight(playerPane);

        // Set up the center of the game pane: displaying opponent hands

    }

    private Hand createHand() {
        Deck deck = new Deck(new Stack<>());
        Hand hand = new Hand(new ArrayList<>());
        while (!hand.isFull()) {
            hand.add(deck.dealACard());
        }
        return hand;
    }

}
