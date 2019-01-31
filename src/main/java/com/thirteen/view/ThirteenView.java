package com.thirteen.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

/**
 * Assets and constants to be used by game UI.
 *
 * @author Michael Kha
 */
public interface ThirteenView {

    /**
     * Default insets value
     */
    Insets DEFAULT_INSETS = new Insets(15);

    /**
     * Path for image files
     */
    String IMAGE_LOCATION = "file:src/main/resources/img/";

    /**
     * The game table pattern
     */
    ImagePattern TABLE = new ImagePattern(new Image(IMAGE_LOCATION + "table-texture.jpg"));

    /**
     * Generic method to be used by any region to resize itself to
     * a default size characterized by its min and max widths and heights
     * being equal.
     * @param region    Region to set to default size
     * @param width     Default width
     * @param height    Default height
     */
    static void setDefSize(Region region, double width, double height) {
        region.setMinSize(width, height);
        region.setMaxSize(width, height);
    }

}
