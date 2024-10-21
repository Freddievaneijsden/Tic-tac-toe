package com.example.tictactoe.controller;

import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import static com.example.tictactoe.Position.*;

public class Controller {

    public void initialize() {
        startRandomEvent();
    }

    private void startRandomEvent () {
        Timeline timeLine = new Timeline(   //tid som går
                new KeyFrame(
                        Duration.millis(Math.random() * 3000),
                        (ActionEvent event) -> {
                            model.npcMove();
                            Controller.this.startRandomEvent();}
                )
        );
        timeLine.play();
    }

    Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void positionOneClicked(MouseEvent mouseEvent) {
        model.selectedPosition(FIRST);
    }

    public void positionTwoClicked(MouseEvent mouseEvent) {
        model.selectedPosition(SECOND);
    }

    public void positionThreeClicked(MouseEvent mouseEvent) {
        model.selectedPosition(THIRD);
    }

    public void positionFourClicked(MouseEvent mouseEvent) {
        model.selectedPosition(FOURTH);
    }

    public void positionFiveClicked(MouseEvent mouseEvent) {
        model.selectedPosition(FIFTH);
    }

    public void positionSixthClicked(MouseEvent mouseEvent) {
        model.selectedPosition(SIXTH);
    }

    public void positionSeventhClicked(MouseEvent mouseEvent) {
        model.selectedPosition(SEVENTH);
    }

    public void positionEighthClicked(MouseEvent mouseEvent) {
        model.selectedPosition(EIGHTH);
    }

    public void positionNinthClicked(MouseEvent mouseEvent) {
        model.selectedPosition(NINTH);
    }
}