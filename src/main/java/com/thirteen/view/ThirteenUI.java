package com.thirteen.view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * The application representing the graphical user interface
 * for the game of thirteen.
 *
 * @author Michael Kha
 */
public class ThirteenUI extends Application {

    /**
     * Title of the stage
     */
    private static final String TITLE = "Thirteen";

    private static final int MAX_WIDTH = 1280;

    private static final int MAX_HEIGHT = 720;

    /**
     * Create the content for the scene.
     * @param playerName    The name of the player
     * @return  Parent node populated with content
     */
    private Parent createContent(String playerName) {
        // TODO: use controller to give GamePane the hands
        return new GamePane(playerName);
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
        List<String> args = parameters.getRaw();
        if (args.size() == 0) {
            System.out.println("usage: ThirteenUI name");
            System.exit(1);
        }
        // Build name
        String playerName = "";
        for (String s : args) {
            playerName += s;
            playerName += ' ';
        }
        // TODO: Evaluate name to be valid

        // Build scene
        Parent parent = createContent(playerName);
        Scene scene = new Scene(parent);

        // Setup stage
        stage.setTitle(TITLE);
        stage.setScene(scene);
        // Set size of application window to only be a single size
        stage.setMaxWidth(MAX_WIDTH);
        stage.setMaxHeight(MAX_HEIGHT);
        stage.setMaximized(true);
        stage.setMinHeight(MAX_HEIGHT);
        stage.setMinWidth(MAX_WIDTH);
        // Disable mouse to show resize arrows
        stage.setResizable(false);
        stage.show();
    }

}
