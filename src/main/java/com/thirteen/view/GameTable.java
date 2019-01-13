package com.thirteen.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Michael Kha
 */
public class GameTable extends Application {

    /**
     * Title of the stage
     */
    private static final String TITLE = "Thirteen";

    @Override
    public void start(Stage stage) {
        // Take in player name
        Parameters parameters = getParameters();

        // Build scene
        GridPane gridPane = new GridPane();
        Image image = new Image("");
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                gridPane.add(new ImageView(image), col, row);
            }
        }

        Scene scene = new Scene(gridPane);

        // Setup stage
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

}
