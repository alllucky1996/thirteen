package com.thirteen.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * TODO: document
 */
public interface ThirteenView {

    Insets DEFAULT_INSETS = new Insets(15);

    String BACKGROUND_LOCATION = "file:src/main/resources/img/background.png";

    Background DEFAULT_BACKGROUND =
            new Background(new BackgroundImage(
            new Image(BACKGROUND_LOCATION), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, null, null));

    Background LIGHT_GREEN_BACKGROUND =
            new Background(new BackgroundFill(Color.GREEN.brighter(),
                    CornerRadii.EMPTY, Insets.EMPTY));

    static void setDefSize(Region region, double width, double height) {
        region.setMinSize(width, height);
        region.setMaxSize(width, height);
    }

}
