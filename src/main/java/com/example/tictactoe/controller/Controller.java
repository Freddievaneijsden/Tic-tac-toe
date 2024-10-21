package com.example.tictactoe.controller;

import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.scene.input.MouseEvent;

import static com.example.tictactoe.Position.*;

public class Controller {

    public void initialize() {
    }

    private void handleMove(Position position) {
        model.selectedPosition(position);
//        model.printAvailablePositions();
        if (!model.getAvailablePositions().isEmpty()) {
            model.npcMove();
        }

        // Check if the move resulted in a winning condition
        if (model.isWinning()) {
            System.out.println("We have a winner!");
            model.resetGame();
        } else if (model.getMoveCount() == 9) {
            System.out.println("Drawn!");
            model.resetGame();
        }
    }

    Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void positionOneClicked(MouseEvent mouseEvent) {
        handleMove(FIRST);
    }

    public void positionTwoClicked(MouseEvent mouseEvent) {
        handleMove(SECOND);
    }

    public void positionThreeClicked(MouseEvent mouseEvent) {
        handleMove(THIRD);
    }

    public void positionFourClicked(MouseEvent mouseEvent) {
        handleMove(FOURTH);
    }

    public void positionFiveClicked(MouseEvent mouseEvent) {
        handleMove(FIFTH);
    }

    public void positionSixthClicked(MouseEvent mouseEvent) {
        handleMove(SIXTH);
    }

    public void positionSeventhClicked(MouseEvent mouseEvent) {
        handleMove(SEVENTH);
    }

    public void positionEighthClicked(MouseEvent mouseEvent) {
        handleMove(EIGHTH);
    }

    public void positionNinthClicked(MouseEvent mouseEvent) {
        handleMove(NINTH);
    }
}