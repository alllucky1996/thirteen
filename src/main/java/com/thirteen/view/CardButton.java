package com.thirteen.view;

import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * A toggle button representing a clickable card.
 *
 * @author Michael Kha
 */
public class CardButton extends ToggleButton implements CardView {

    /**
     * Width and height of card constants used to represent state
     */
    private static final double HOVER_WIDTH = CARD_WIDTH / 6;

    private static final double HOVER_HEIGHT = CARD_HEIGHT / 6;

    private static final double SELECT_WIDTH = CARD_WIDTH / 8.5;

    private static final double SELECT_HEIGHT = CARD_HEIGHT / 8.5;

    private static final double DEFAULT_WIDTH = CARD_WIDTH / 10;

    private static final double DEFAULT_HEIGHT = CARD_HEIGHT / 10;

    /**
     * TODO: see if field is needed
     * CardImage used to represent the button
     */
    private CardImage cardImage;

    /**
     * ImageView to display the CardImage
     */
    private ImageView imageView;

    /**
     * Create a card button given a card image.
     * @param cardImage     Card image representing a single card
     */
    public CardButton(CardImage cardImage) {
        imageView = CardView.createImageView(cardImage);
        imageView.setFitWidth(DEFAULT_WIDTH);
        imageView.setFitHeight(DEFAULT_HEIGHT);
        this.cardImage = cardImage;
        setGraphic(imageView);
        setMouseEvents();
    }

    /**
     * Set the mouse events of the card button. Mouse events
     * consisting of clicking and hovering, change the size of the button.
     * By default, a toggle button is toggled when clicked.
     */
    private void setMouseEvents() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setImageViewFitSize(HOVER_WIDTH, HOVER_HEIGHT);
            }
        });
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeImageViewSizeDependingOnToggle();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeImageViewSizeDependingOnToggle();
            }
        });
    }

    /**
     * Change the image view size depending on the toggle button's select
     * property.
     */
    private void changeImageViewSizeDependingOnToggle() {
        if (isSelected()) {
            setImageViewFitSize(SELECT_WIDTH, SELECT_HEIGHT);
        } else {
            setImageViewFitSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    /**
     * Set the image view fit size to the specified width and height.
     * @param width     Width to set to
     * @param height    Height to set to
     */
    private void setImageViewFitSize(double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }

}
