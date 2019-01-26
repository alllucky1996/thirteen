package com.thirteen.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * TODO: document
 */
public interface ThirteenView {

    Insets DEFAULT_INSETS = new Insets(15);

    String IMAGE_LOCATION = "file:src/main/resources/img/";

    ImagePattern TABLE = new ImagePattern(new Image(IMAGE_LOCATION + "table-texture.jpg"));

    Background TABLE_BACKGROUND =
            new Background(new BackgroundImage(
            new Image(IMAGE_LOCATION + "table-texture.jpg"), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, null, null));

    Background LIGHT_GREEN_BACKGROUND =
            new Background(new BackgroundFill(Color.GREEN.brighter(),
                    CornerRadii.EMPTY, Insets.EMPTY));

    static void setDefSize(Region region, double width, double height) {
        region.setMinSize(width, height);
        region.setMaxSize(width, height);
    }

}
