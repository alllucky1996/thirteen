package com.thirteen.view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

/**
 * The table representing the graphical user interface
 * for the game of thirteen.
 *
 * @author Michael Kha
 */
public class GameTable extends Application {

    /**
     * Title of the stage
     */
    private static final String TITLE = "Thirteen";

    /**
     * File location of the background image
     */
    private static final String BACKGROUND_PATH = "src/main/resources/img/background.png";

    /**
     * Create the content for the scene.
     * @return  Parent node populated with content
     */
    private Parent createContent() {
        GridPane gridPane = new GridPane();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                //gridPane.add(new ImageView(image), col, row);
            }
        }
        BorderPane borderPane = new BorderPane();
        //borderPane.setBackground(new Background(loadBackground()));
        StackPane stackPane = new StackPane(borderPane, gridPane);
        stackPane.setBackground(new Background(loadBackground()));
        return stackPane;
    }

    /**
     * Load the background image from a file.
     * @return  The background image
     */
    private BackgroundImage loadBackground() {
        File file = new File(BACKGROUND_PATH);
        Image image =  new Image(file.toURI().toString());
        return new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, null, null);
    }

    /**
     * Initialize the application by creating and loading content onto
     * the stage to be shown.
     * @param stage Stage to setup and show
     */
    @Override
    public void start(Stage stage) {
        // Take in player name
        Parameters parameters = getParameters();

        // Build scene
        Parent parent = createContent();
        Scene scene = new Scene(parent);

        // Setup stage
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        stage.setMaximized(true);
        stage.show();
    }

}
