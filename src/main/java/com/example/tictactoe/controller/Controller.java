package com.example.tictactoe.controller;

import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.Random;

import static com.example.tictactoe.GameState.*;
import static com.example.tictactoe.Players.*;
import static com.example.tictactoe.Position.*;

public class Controller {
    Model model = new Model(new Random());
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;

    public void initialize() {
        startRandomEvent();
    }

    private void startRandomEvent() {
        Timeline timeLine = new Timeline(
                new KeyFrame(
                        Duration.millis(Math.random() * 3000),
                        (ActionEvent event) -> {
                            colorToIndicateTurn();
                            model.npcMove();
                            Controller.this.startRandomEvent();
                        }
                )
        );
        timeLine.play();
    }

    public void colorToIndicateTurn() {
        if (model.getGameState().equals(RUNNING)) {
            if (model.getCurrentPlayer().equals(PLAYER1)) {
                player1Label.setStyle("-fx-text-fill: RED;");
                player2Label.setStyle("-fx-text-fill: BLACK;");
            } else {
                player1Label.setStyle("-fx-text-fill: BLACK;");
                player2Label.setStyle("-fx-text-fill: BLUE;");
            }
        }
    }

    public Model getModel() {
        return model;
    }

    public void restartClicked(MouseEvent mouseEvent) {
        model.resetGame();
    }

    public void positionClicked(MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        String id = source.getId();

        Position position = checkPosition(id);
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(position);
        }
    }

    private static Position checkPosition(String id) {
        Position position;
        switch (id) {
            case "imageView1" -> position = FIRST;
            case "imageView2" -> position = SECOND;
            case "imageView3" -> position = THIRD;
            case "imageView4" -> position = FOURTH;
            case "imageView5" -> position = FIFTH;
            case "imageView6" -> position = SIXTH;
            case "imageView7" -> position = SEVENTH;
            case "imageView8" -> position = EIGHTH;
            case "imageView9" -> position = NINTH;
            default -> throw new IllegalArgumentException("Unexpected id: " + id);
        }
        return position;
    }
}