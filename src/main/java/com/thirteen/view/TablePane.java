package com.thirteen.view;

import com.thirteen.model.Hand;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * A pane that represents a table composed of opponent hand panes
 * around the table.
 *
 * @author Michael Kha
 */
public class TablePane extends Pane implements ThirteenView {

    /**
     * Constants used to position the table
     */
    private static final double CENTER_X = 600;
    private static final double CENTER_Y = 350;

    /**
     * Constants used to size the table
     */
    private static final double RADIUS_X = 300;
    private static final double RADIUS_Y = 150;
    private static final double RADIUS_DIFF = 10;

    /**
     * Create the table pane with ellipses representing the table and each
     * opposing hand.
     * @param hands The opposing hands to display
     */
    TablePane(Hand... hands) {
        // Create the table
        Shape tableEdge = new Ellipse(CENTER_X, CENTER_Y, RADIUS_X, RADIUS_Y);
        Shape table = new Ellipse(CENTER_X, CENTER_Y, RADIUS_X - RADIUS_DIFF,
                RADIUS_Y - RADIUS_DIFF);
        tableEdge.setFill(Color.SADDLEBROWN);
        table.setFill(TABLE);
        getChildren().addAll(tableEdge, table);
        // Generate opposing hand panes
        OpposingHandPane[] handPanes = new OpposingHandPane[hands.length];
        for (int i = 0; i < hands.length; i++) {
            handPanes[i] = new OpposingHandPane(hands[i]);
        }
        int count = 0;
        while (count != handPanes.length) {
            getChildren().add(handPanes[count]);
            // Position the hand panes on the table pane
            switch (count) {
                case 0:
                    handPanes[count].setLayoutX(500);
                    handPanes[count].setLayoutY(150);
                    break;
                case 1:
                    handPanes[count].setLayoutX(100);
                    handPanes[count].setLayoutY(300);
                    break;
                case 2:
                    handPanes[count].setLayoutX(900);
                    handPanes[count].setLayoutY(300);
                    break;
            }
            count++;
        }
        setPadding(DEFAULT_INSETS);
    }

}
