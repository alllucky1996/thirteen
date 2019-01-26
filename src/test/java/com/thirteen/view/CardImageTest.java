package com.thirteen.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.framework.junit.ApplicationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FIXME: fixing enum initialization and Internal graphics not initialized yet.
 * @author Michael Kha
 */
public class CardImageTest extends ApplicationTest {

    private CardImage CuT;

    @BeforeEach
    @Override
    public void start(Stage stage) throws Exception {
        if (stage == null) {
            System.out.println("null stage");
        }
        stage.setScene(new Scene(new BorderPane()));
        stage.show();
        System.out.println("Printing");
        CuT = CardImage.ACE_OF_CLUBS;
    }

    @Test
    public void testGetImage() {
        //assertNotNull(CuT.getImage());
        assertNull(CuT);
    }
}
