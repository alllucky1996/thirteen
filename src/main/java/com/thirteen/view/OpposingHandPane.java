package com.thirteen.view;

import com.thirteen.model.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class OpposingHandPane extends Pane implements CardView, ThirteenView {

    private static final double DEFAULT_WIDTH = CARD_WIDTH / 10;

    private static final double DEFAULT_HEIGHT = CARD_HEIGHT / 10;

    private static final double DEFAULT_X_POS = DEFAULT_WIDTH / 2;

    private static final double DEFAULT_Y_POS = CARD_HEIGHT / 8;

    private Text cardNumInfo;

    // TODO: change to hand size parameter?
    OpposingHandPane(Hand hand) {
        ObservableList<Node> children = getChildren();
        CardID cardBack = new CardID(Rank.BACK, Suit.BACK);
        cardNumInfo = new Text();
        cardNumInfo.setText(hand.size() + " CARDS");
        cardNumInfo.setLayoutX(DEFAULT_X_POS * (hand.size() - 1) / 2);
        cardNumInfo.setLayoutY(DEFAULT_Y_POS);
        cardNumInfo.setVisible(false);
        children.add(cardNumInfo);
        for (int i = 0; i < hand.size(); i++) {
            ImageView imageView = createImageView(cardBack);
            imageView.setLayoutX(DEFAULT_X_POS * i);
            children.add(imageView);
        }
        setMouseEvents();
        setPadding(DEFAULT_INSETS);
    }

    private void setMouseEvents() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cardNumInfo.setVisible(true);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cardNumInfo.setVisible(false);
            }
        });
    }

    private ImageView createImageView(CardID cardID) {
        ImageView imageView = CardView.createImageView(CardImage.CARD_IMAGES.get(cardID));
        imageView.setFitWidth(DEFAULT_WIDTH);
        imageView.setFitHeight(DEFAULT_HEIGHT);
        return imageView;
    }

}
