package com.example.tictactoe.controller;

import com.example.tictactoe.Players;
import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import static com.example.tictactoe.Players.*;
import static com.example.tictactoe.Position.*;

public class Controller {

    Model model = new Model();

    public void initialize() {
        startRandomEvent();
    }

    private void startRandomEvent() {
        Timeline timeLine = new Timeline(
                new KeyFrame(
                        Duration.millis(Math.random() * 3000),
                        (ActionEvent event) -> {
                            model.npcMove();
                            Controller.this.startRandomEvent();
                        }
                )
        );
//        if (model.isWinning()) timeLine.pause();
        timeLine.play();
    }

    public Model getModel() {
        return model;
    }

    public void restartClicked (MouseEvent mouseEvent) {
        model.resetGame();
    }

    public void positionOneClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(FIRST);
        }
    }

    public void positionTwoClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(SECOND);
        }
    }

    public void positionThreeClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(THIRD);
        }
    }

    public void positionFourClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(FOURTH);
        }
    }

    public void positionFiveClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(FIFTH);
        }
    }

    public void positionSixthClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(SIXTH);
        }
    }

    public void positionSeventhClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(SEVENTH);
        }
    }

    public void positionEighthClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(EIGHTH);
        }
    }

    public void positionNinthClicked(MouseEvent mouseEvent) {
        if (model.getCurrentPlayer().equals(PLAYER1)) {
            model.selectedPosition(NINTH);
        }
    }
}