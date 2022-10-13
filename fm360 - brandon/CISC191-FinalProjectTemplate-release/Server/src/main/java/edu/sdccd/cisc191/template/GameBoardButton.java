package edu.sdccd.cisc191.template;

import javafx.scene.control.Button;

import java.util.Random;
import java.util.TimerTask;

/**
 * Extends the basic JavaFX Button with game functionality
 */
public class GameBoardButton extends Button {
    public boolean startGame;
    public boolean isGreen;

    public GameBoardButton(boolean startGame, boolean isGreen)
    {

        this.startGame = startGame;
        this.isGreen = isGreen;

        // TODO: set min/pref width, default text
        setStyle("-fx-background-color: #ff0000; ");
        setMinWidth(300);
        setMinHeight(300);
        setPrefWidth(500);
        setPrefHeight(500);
        setText("CLICK TO START");

    }

    public void handleClick() {
        // TODO: update text
        if(!startGame) {
            startGame = true;
            setText("WAIT");
        }

    }

    public void textState(){
        if(isGreen){
            setText("GO!!!");
        }
    }

}