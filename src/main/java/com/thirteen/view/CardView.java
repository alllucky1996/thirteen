package com.thirteen.view;

import javafx.scene.image.ImageView;

/**
 * TODO: document
 */
public interface CardView {

    double CARD_HEIGHT = 726;

    double CARD_WIDTH = 500;

    static ImageView createImageView(CardImage cardImage) {
        return new ImageView(cardImage.getImage());
    }

}
