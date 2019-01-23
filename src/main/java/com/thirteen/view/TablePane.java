package com.thirteen.view;

import com.thirteen.model.Hand;
import javafx.scene.layout.Pane;

public class TablePane extends Pane {

    // TODO: change to different pane/layout
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
                    handPanes[count].setLayoutX(0);
                    handPanes[count].setLayoutY(200);
                    //setCenter(handPanes[count]);
                    //setAlignment(handPanes[count], Pos.BOTTOM_CENTER);
                    break;
                case 1:
                    handPanes[count].setLayoutX(-100);
                    handPanes[count].setLayoutY(300);
                    //setLeft(handPanes[count]);
                    //setAlignment(handPanes[count], Pos.BOTTOM_RIGHT);
                    break;
                case 2:
                    handPanes[count].setLayoutX(100);
                    handPanes[count].setLayoutY(300);
                    //setRight(handPanes[count]);
                    //setAlignment(handPanes[count], Pos.BOTTOM_LEFT);
                    break;
            }
            count++;
        }
    }

}
