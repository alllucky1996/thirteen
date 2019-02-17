package com.thirteen.view.menu;

import com.thirteen.view.ThirteenView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Simple login form.
 *
 * @author Michael Kha
 */
public class LoginForm extends GridPane implements ThirteenView {

    private static final String FONT = "Verdana";
    private static final String REGEX = "^(?=.{8,20}$)(?![_.])" +
            "(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private static final String INVALID_NAME_MESSAGE = "Invalid username." +
            " Username must be 8-20 characters and can only contain" +
            " alphanumeric characters, underscores, and periods.";
    private static final String EMPTY_NAME_MESSAGE = "Username must contain " +
            "8-20 characters.";

    LoginForm() {
        setAlignment(Pos.CENTER);
        setHgap(5);
        setVgap(5);
        setPadding(DEFAULT_INSETS);
        // Create form title
        add(createTitle(), 0, 0, 2, 1);
        // Create username label
        add(createUserLabel(), 0 , 1);
        // Create username text field
        TextField userTextField = createUserTextField();
        add(createUserTextField(), 1, 1);
        // Create event text
        Text eventText = createEventText();
        add(eventText, 1, 5);
        // Create login input
        HBox loginInput = createLoginInput(userTextField, eventText);
        add(loginInput, 1, 3);
    }

    private Text createTitle() {
        Text text = new Text("Thirteen");
        text.setFont(Font.font(FONT, FontWeight.NORMAL, 20));
        return text;
    }

    private Label createUserLabel() {
        Label label = new Label("Username:");
        label.setFont(Font.font(FONT, FontWeight.NORMAL, 14));
        return label;
    }

    private TextField createUserTextField() {
        return new TextField();
    }

    private Text createEventText() {
        Text text = new Text();
        text.setFont(Font.font(FONT, FontWeight.NORMAL, 14));
        text.setFill(Color.FIREBRICK);
        return text;
    }

    private HBox createLoginInput(TextField userTextField, Text eventText) {
        Button button = new Button("Sign In");
        button.setOnAction((a) -> {
            String text = userTextField.getText();
            if (text.matches(REGEX)) {
                // Good input
            }
            else {
                if (text.length() != 0) {
                    eventText.setText(INVALID_NAME_MESSAGE);
                } else {
                    eventText.setText(EMPTY_NAME_MESSAGE);
                }
            }

        });
        HBox hBox = new HBox(10, button);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        return hBox;
    }
}
