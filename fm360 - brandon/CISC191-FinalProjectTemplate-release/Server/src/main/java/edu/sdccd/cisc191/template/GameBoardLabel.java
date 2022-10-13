package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Extends the basic JavaFX Label with game functionality
 */
public class GameBoardLabel extends Label {
    public static Insets LABEL_PADDING = new Insets(20);

    public GameBoardLabel() {
        // TODO: set Label properties like padding
        setPadding(LABEL_PADDING);
        setFont(Font.font("ROBOTO", FontWeight.BOLD, 20));

    }
}