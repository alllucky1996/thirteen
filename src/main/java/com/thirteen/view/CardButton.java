package com.thirteen.view;

import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardButton extends ToggleButton implements CardView {

    private static final double HOVER_WIDTH = IMAGE_WIDTH/5;

    private static final double HOVER_HEIGHT = IMAGE_HEIGHT/5;

    private static final double DEFAULT_WIDTH = IMAGE_WIDTH/6;

    private static final double DEFAULT_HEIGHT = IMAGE_HEIGHT/6;

    private CardImage cardImage;

    private ImageView imageView;

    public CardButton(CardImage cardImage) {
        imageView = createImageView(cardImage);
        imageView.setFitWidth(DEFAULT_WIDTH);
        imageView.setFitHeight(DEFAULT_HEIGHT);
        this.cardImage = cardImage;
        setGraphic(imageView);
        setMouseEvents();
    }

    private void setMouseEvents() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setFitWidth(HOVER_WIDTH);
                imageView.setFitHeight(HOVER_HEIGHT);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isSelected()) {
                    imageView.setFitWidth(DEFAULT_WIDTH);
                    imageView.setFitHeight(DEFAULT_HEIGHT);
                }
            }
        });
    }

    @Override
    public ImageView createImageView(CardImage cardImage) {
        return new ImageView(cardImage.getImage());
    }

}
