package com.thirteen.view;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Optional;

/**
 * A grid pane used to represent the player UI. The player UI
 * allows the cards in hand to be interacted with given it is their turn.
 *
 * @author Michael Kha
 */
public class PlayerPane extends GridPane implements ThirteenView {

    /**
     * Strings used to represent the state of the game to be shown
     */
    private static final String PLAYER_TURN = "%s's Turn";
    private static final String WAITING = "Waiting...";

    /**
     * Strings used to represent the move state.
     */
    private static final String MAKE_MOVE = "Make a Move!";
    private static final String VALID_MOVE = "Valid Move.";
    private static final String INVALID_MOVE = "Invalid Move.";

    /**
     * The turn text to display the state of the game.
     */
    private final Text turn;

    /**
     * The indicator text to display the move state.
     */
    private final Text indicator;

    /**
     * Create a player pane given a player name.
     * @param playerName    The name of the player to display
     */
    PlayerPane(String playerName) {
        // TODO: change text depending on game state
        // text about whose turn it is: "NAME's Turn"
        turn = new Text();
        turn.setText(String.format(PLAYER_TURN, playerName));

        // style text
        //turn.setStyle();

        // text indicating if move is valid or invalid
        indicator = new Text();
        indicator.setText(MAKE_MOVE);

        // make move button at bottom
        Button makeMove = createButton("Make Move");
        ThirteenView.setDefSize(makeMove, 100, 50);
        // click event
        makeMove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        // show text indicating if move is valid

        // undo move button
        Button undoMove = createButton("Undo Move");
        ThirteenView.setDefSize(undoMove, 100, 50);
        undoMove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        // end turn button
        Button endTurn = createButton("End Turn");
        ThirteenView.setDefSize(endTurn, 200, 80);
        endTurn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // if move is pass
            //    showPassAlert();
                // otherwise submit

            }
        });
        BorderPane buttons = new BorderPane();
        buttons.setLeft(makeMove);
        buttons.setRight(undoMove);
        buttons.setBottom(endTurn);
        // Add to PlayerPane
        add(turn, 0, 0);
        add(indicator, 0, 1);
        add(buttons, 0, 2);
        setPadding(DEFAULT_INSETS);
    }

    /**
     * Create a button that is initially disabled.
     * @param text  Text on the button to display
     * @return  A formatted button
     */
    private Button createButton(String text) {
        Button button = new Button(text);
        // TODO: add observers to enable buttons
        button.setDisable(true);
        return button;
    }

    /**
     * TODO: use pass alert
     * Show a warning alert about making a passing move.
     */
    private void showPassAlert() {
        // if move is empty: display pass move warning through an alert
        // alert asks "Are you sure?" in the prompt and in the body
        // "You are about to submit a passing move."
        // while giving two options, "Cancel" or "Submit turn"
        Alert passAlert = new Alert(Alert.AlertType.CONFIRMATION);
        passAlert.setTitle("Confirmation");
        passAlert.setHeaderText("You are about to submit a passing move.");
        passAlert.setContentText("Are you sure?");

        // Custom alert buttons
        ButtonType cancel = new ButtonType("Cancel");
        ButtonType submit = new ButtonType("OK");

        passAlert.getButtonTypes().clear();
        passAlert.getButtonTypes().addAll(cancel, submit);

        // TODO
        // Get result from alert
        Optional<ButtonType> option = passAlert.showAndWait();
        ButtonType actual = option.orElse(null);

        if (actual == cancel) {
            // do nothing
        } else if (actual == submit) {
            // submit turn
        }
    }

}
