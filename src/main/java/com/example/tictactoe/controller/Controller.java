package com.example.tictactoe.controller;

import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import javax.print.attribute.standard.PDLOverrideSupported;

import static com.example.tictactoe.Position.*;

public class Controller {

    public void initialize() {
    }

    private void handleMove(Position position) {
        model.selectedPosition(position); // Register the move

        // Check if the move resulted in a winning condition
        if (model.isWinning()) {
            System.out.println("We have a winner!");
        }
    }

    Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void positionOneClicked(MouseEvent mouseEvent) {
        model.selectedPosition(FIRST);
        handleMove(FIRST);
    }

    public void positionTwoClicked(MouseEvent mouseEvent) {
        model.selectedPosition(SECOND);
        handleMove(SECOND);
    }

    public void positionThreeClicked(MouseEvent mouseEvent) {
        model.selectedPosition(THIRD);
        handleMove(THIRD);
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