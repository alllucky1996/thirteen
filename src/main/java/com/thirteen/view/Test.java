package com.thirteen.view;

import com.thirteen.model.Deck;
import com.thirteen.model.Hand;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Test extends Application implements CardView, ThirteenView {

    private static final double MAX_WIDTH = 700;

    private static final double MAX_HEIGHT = 400;

    @Override
    public void start(Stage stage) {
        //HBox hBox = new HBox();
        //for (int i = 0; i < 13; i++) {
        //    ToggleButton cardBack = createCard(CardImage.CARD_BACK);
        //    hBox.getChildren().add(cardBack);
        //}
        //hBox.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
        BorderPane borderPane = new BorderPane();

        AnchorPane wrap = new AnchorPane();
        HBox handPane = new HandPane(createHand());
        //handPane.setPrefSize(CARD_WIDTH / 5 * 13, CARD_HEIGHT / 5);
        ThirteenView.setDefSize(handPane, CARD_WIDTH / 5 * 13, CARD_HEIGHT / 5);
        handPane.setAlignment(Pos.BOTTOM_LEFT);

        PlayerPane playerPane = new PlayerPane("Mike");
        playerPane.setAlignment(Pos.BOTTOM_RIGHT);

        //wrap.add(handPane, 0, 0);
        //wrap.add(playerPane, 1, 0);
        AnchorPane.setLeftAnchor(handPane, 30.0);
        AnchorPane.setRightAnchor(playerPane, 30.0);

        wrap.getChildren().addAll(handPane, playerPane);

        borderPane.setBottom(wrap);

        //Pane left = new OpposingHandPane(createHand());
        //HBox leftWrap = new HBox(left);
        //Pane center = new OpposingHandPane(createHand());
        //HBox centerWrap = new HBox(center);
        //Pane right = new OpposingHandPane(createHand());
        //HBox rightWrap = new HBox(right);
        //borderPane.setLeft(leftWrap);
        //borderPane.setCenter(centerWrap);
        //borderPane.setRight(rightWrap);

        TablePane tablePane = new TablePane(createHand(), createHand(), createHand());
        borderPane.setCenter(tablePane);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    private Hand createHand() {
        Deck deck = new Deck(new Stack<>());
        Hand hand = new Hand(new ArrayList<>());
        while (!hand.isFull()) {
            hand.add(deck.dealACard());
        }
        return hand;
    }

    private ToggleButton createCard(CardImage cardImage) {
        return new CardButton(cardImage);
    }

}
