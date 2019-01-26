package com.thirteen.view;

import com.thirteen.model.Hand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * TODO: document
 */
public class TablePane extends Pane implements ThirteenView {

    TablePane(Hand... hands) {
        Shape ellipse = new Ellipse(600, 350, 300, 150);
        ellipse.setFill(TABLE);
        getChildren().add(ellipse);

        OpposingHandPane[] handPanes = new OpposingHandPane[hands.length];
        for (int i = 0; i < hands.length; i++) {
            handPanes[i] = new OpposingHandPane(hands[i]);
        }
        int count = 0;
        while (count != handPanes.length) {
            getChildren().add(handPanes[count]);
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
