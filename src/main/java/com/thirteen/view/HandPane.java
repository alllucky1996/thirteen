package com.thirteen.view;

import com.thirteen.model.Card;
import com.thirteen.model.Hand;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HandPane extends HBox {

    private static final double MAX_WIDTH = 700;

    private static final double MAX_HEIGHT = 400;

    HandPane(Hand hand) {
        ObservableList<Node> children = getChildren();
        for (Card card : hand.getCards()) {
            // FIXME: Java 11 runtime exception :( using Java 9 for now
            children.add(new CardButton(CardImage.CARD_IMAGES.get(card.getID())));
        }
    }

}
