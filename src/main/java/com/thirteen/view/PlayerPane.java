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
 * TODO: document
 */
public class PlayerPane extends GridPane implements ThirteenView {

    private static final String PLAYER_TURN = "%s's Turn";
    private static final String WAITING = "Waiting...";
    private static final String MAKE_MOVE = "Make a Move!";
    private static final String VALID_MOVE = "Valid Move.";
    private static final String INVALID_MOVE = "Invalid Move.";

    private final Text turn;
    private final Text indicator;

    PlayerPane(String player) {
        // TODO: change text depending on game state
        // text about whose turn it is: "NAME's Turn"
        turn = new Text();
        turn.setText(String.format(PLAYER_TURN, player));

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
            //    showAlert();
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
        //add(makeMove, 0, 2);
        //add(undoMove, 1, 2);
        //add(endTurn, 0, 3);
        setPadding(DEFAULT_INSETS);
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        // TODO: add observers to enable buttons
        //button.setDisable(true);
        return button;
    }

    private void showAlert() {
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
