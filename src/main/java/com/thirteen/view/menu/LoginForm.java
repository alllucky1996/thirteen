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

    /**
     * Default font
     */
    private static final String FONT = "Verdana";
    /**
     * Regular expression for valid username
     */
    private static final String REGEX =
            "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})" +
            "[a-zA-Z0-9._]+(?<![_.])$";
    /**
     * Invalid username message
     */
    private static final String INVALID_NAME_MESSAGE =
            "Username must have 4-20 characters and\ncan only contain" +
            " letters, numbers,\nunderscores and periods.";
    /**
     * Empty username message
     */
    private static final String EMPTY_NAME_MESSAGE = "Username must contain " +
            "4-20 characters.";

    /**
     * Create a login form that utilizes a grid pane.
     */
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
        add(userTextField, 1, 1);
        // Create event text
        Text eventText = createEventText();
        add(eventText, 0, 5, 2, 1);
        // Create login input
        HBox loginInput = createLoginInput(userTextField, eventText);
        add(loginInput, 1, 3);
    }

    /**
     * Create a text title for the login form.
     * @return  Large text title of the application name
     */
    private Text createTitle() {
        Text text = new Text("Thirteen");
        text.setFont(Font.font(FONT, FontWeight.NORMAL, 20));
        return text;
    }

    /**
     * Create a label for the text field.
     * @return  Label indicating the text field is for a username.
     */
    private Label createUserLabel() {
        Label label = new Label("Username:");
        label.setFont(Font.font(FONT, FontWeight.NORMAL, 14));
        return label;
    }

    /**
     * Create the text field to read the username from.
     * @return  The text field
     */
    private TextField createUserTextField() {
        return new TextField();
    }

    /**
     * Create the event text to be used to show error messages.
     * @return  The formatted event text
     */
    private Text createEventText() {
        Text text = new Text();
        text.setFont(Font.font(FONT, FontWeight.NORMAL, 11.5));
        text.setFill(Color.FIREBRICK);
        return text;
    }

    /**
     * Create a login input button oriented to the bottom right. The input
     * button has an action event that reads the text field to determine
     * if it should show an error message or continue login in.
     * @param userTextField Text field to read username from
     * @param eventText Event text to possibly show error message
     * @return  Login input button wrapped by an HBox
     */
    private HBox createLoginInput(TextField userTextField, Text eventText) {
        Button button = new Button("Sign In");
        button.setOnAction((a) -> {
            String text = userTextField.getText();
            if (text.matches(REGEX)) {
                // Good input
                // TODO: take username and create player
                eventText.setText("");
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
