package com.thirteen.view;

import com.thirteen.model.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * TODO: document
 */
public class OpposingHandPane extends Pane implements CardView, ThirteenView {

    private static final double DEFAULT_WIDTH = CARD_WIDTH / 14;

    private static final double DEFAULT_HEIGHT = CARD_HEIGHT / 14;

    private static final double DEFAULT_X_POS = DEFAULT_WIDTH / 2.5;

    private Text cardNumInfo;

    // TODO: change to hand size parameter?
    OpposingHandPane(Hand hand) {
        ObservableList<Node> children = getChildren();
        CardID cardBack = new CardID(Rank.BACK, Suit.BACK);
        cardNumInfo = new Text();
        cardNumInfo.setText(hand.size() + " CARDS");
        cardNumInfo.setLayoutY(-5);
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
