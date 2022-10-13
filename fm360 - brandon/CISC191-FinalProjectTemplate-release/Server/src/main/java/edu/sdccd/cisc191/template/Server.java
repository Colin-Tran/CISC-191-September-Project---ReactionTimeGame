package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang.time.StopWatch;

import javax.swing.*;

public class Server extends Application {

    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel currentTime;
    private GameBoardLabel message;
    private StopWatch timeElapsed = new StopWatch();

    Button resetButton;
    Button exitButton;
    public void updateHeader() {
        currentTime.setText("Time: " + timeElapsed.getTime() + "ms");

        message.setText("Test your reaction time!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        controller = new ControllerGameBoard();
        // TODO initialize gameCanvas
        gameCanvas = new Canvas();
        Timer timer = new Timer();
        GameBoardButton button = new GameBoardButton(false, false);

        resetButton = new Button("Restart");
        resetButton.setMinSize(50, 50);


        exitButton = new Button("Exit");
        exitButton.setMinSize(50, 50);
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        currentTime = new GameBoardLabel();
        message = new GameBoardLabel();
        updateHeader();
        HBox gameDisplay = new HBox(50, currentTime, message);
        BorderPane root = new BorderPane();
        root.setTop(gameDisplay);
        VBox buttons = new VBox();
        VBox exitResetButtons = new VBox(50, exitButton, resetButton);
        root.setRight(exitResetButtons);

        TimerTask task = new TimerTask() {

            public void run() {
                button.setStyle("-fx-background-color: #00ff00; ");
                button.isGreen = true;
                button.setDisable(false);
                button.textState();
                timeElapsed.start();
                button.setOnAction(e -> {
                    if (button.isGreen = true) {
                        timeElapsed.stop();
                        updateHeader();
                    }
                });

            }
        };
        setAction(timer, button, task, button);
        buttons.getChildren().add(button);

        resetButton.setOnAction(e -> {
            buttons.getChildren().remove(button);
            GameBoardButton newButtons = new GameBoardButton(false, false);
            buttons.getChildren().add(newButtons);


            setAction(timer, button, task, newButtons);
        });
        // TODO: create scene, stage, set title, and show
        root.setCenter(buttons);
        Scene scene = new Scene(root, 550, 555);
        stage.setScene(scene);
        stage.setTitle("Reaction Test!");
        stage.show();


    }

    private void setAction(Timer timer, GameBoardButton button, TimerTask task, GameBoardButton newButtons) {
        newButtons.setOnAction(q -> {
            button.handleClick();
            if (button.startGame = true) {
                button.setDisable(true);
                int delay = (2 + new Random().nextInt(5)) * 1000;
                timer.schedule(task, delay);
                button.textState();
            }
        });
    }


    public static void main(String[] args) {
        launch();
    }


} //end class Server
