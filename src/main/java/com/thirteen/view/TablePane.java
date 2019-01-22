package com.thirteen.view;

import com.thirteen.model.Hand;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class TablePane extends BorderPane {

    // TODO: change to different pane/layout
    TablePane(Hand... hands) {
        OpposingHandPane[] handPanes = new OpposingHandPane[hands.length];
        for (int i = 0; i < hands.length; i++) {
            handPanes[i] = new OpposingHandPane(hands[i]);
        }
        int count = 0;
        while (count != handPanes.length) {
            switch (count) {
                case 0:
                    setCenter(handPanes[count]);
                    setAlignment(handPanes[count], Pos.BOTTOM_CENTER);
                    break;
                case 1:
                    setLeft(handPanes[count]);
                    setAlignment(handPanes[count], Pos.BOTTOM_RIGHT);
                    break;
                case 2:
                    setRight(handPanes[count]);
                    setAlignment(handPanes[count], Pos.BOTTOM_LEFT);
                    break;
            }
            count++;
        }
    }

}
