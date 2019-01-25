package com.thirteen.view;

import com.thirteen.model.Hand;
import javafx.scene.layout.Pane;

/**
 * TODO: document
 */
public class TablePane extends Pane {

    TablePane(Hand... hands) {
        OpposingHandPane[] handPanes = new OpposingHandPane[hands.length];
        for (int i = 0; i < hands.length; i++) {
            handPanes[i] = new OpposingHandPane(hands[i]);
        }
        int count = 0;
        while (count != handPanes.length) {
            getChildren().add(handPanes[count]);
            switch (count) {
                case 0:
                    handPanes[count].setLayoutX(400);
                    handPanes[count].setLayoutY(50);
                    break;
                case 1:
                    handPanes[count].setLayoutX(100);
                    handPanes[count].setLayoutY(150);
                    break;
                case 2:
                    handPanes[count].setLayoutX(700);
                    handPanes[count].setLayoutY(150);
                    break;
            }
            count++;
        }
    }

}
