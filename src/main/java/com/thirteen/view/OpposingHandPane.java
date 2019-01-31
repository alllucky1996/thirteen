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
 * Pane which holds the opposing players' hands as unknown cards.
 *
 * @author Michael Kha
 */
public class OpposingHandPane extends Pane implements CardView, ThirteenView {

    /**
     * Default width using the card width
     */
    private static final double DEFAULT_WIDTH = CARD_WIDTH / 14;
    /**
     * Default height using the card height
     */
    private static final double DEFAULT_HEIGHT = CARD_HEIGHT / 14;
    /**
     * Default relative x position used to create visual staggering card effect
     */
    private static final double DEFAULT_X_POS = DEFAULT_WIDTH / 2.5;

    /**
     * Text to display the number of cards
     */
    private Text cardNumInfo;

    /**
     * Create an opposing hand pane given a known hand. A hand is needed
     * to correctly update the number of cards in hand.
     * @param hand  Hand to represent
     */
    OpposingHandPane(Hand hand) {
        ObservableList<Node> children = getChildren();
        CardID cardBack = new CardID(Rank.BACK, Suit.BACK);
        cardNumInfo = new Text();
        cardNumInfo.setLayoutY(-5);
        cardNumInfo.setVisible(false);
        children.add(cardNumInfo);
        for (int i = 0; i < hand.size(); i++) {
            ImageView imageView = createImageView(cardBack);
            imageView.setLayoutX(DEFAULT_X_POS * i);
            children.add(imageView);
        }
        setMouseEvents(hand);
        setPadding(DEFAULT_INSETS);
    }

    /**
     * Set the mouse events for the pane. Upon hovering,
     * additional info about the number of cards in hand is detailed.
     */
    private void setMouseEvents(Hand hand) {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cardNumInfo.setText(hand.size() + " CARDS");
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

    /**
     * Create an image view and sets the fit width and fit height to default.
     * @param cardID    The cardID to get the card image
     * @return  An image view of the card
     */
    private ImageView createImageView(CardID cardID) {
        ImageView imageView = CardView.createImageView(
                CardImage.CARD_IMAGES.get(cardID));
        imageView.setFitWidth(DEFAULT_WIDTH);
        imageView.setFitHeight(DEFAULT_HEIGHT);
        return imageView;
    }

}
