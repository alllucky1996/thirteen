package com.thirteen.view;

import javafx.scene.image.ImageView;

public interface CardView {

    double IMAGE_HEIGHT = 726;

    double IMAGE_WIDTH = 500;

    ImageView createImageView(CardImage cardImage);

}
