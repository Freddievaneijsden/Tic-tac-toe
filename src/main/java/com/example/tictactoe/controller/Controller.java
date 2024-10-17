package com.example.tictactoe.controller;

import com.example.tictactoe.Position;
import com.example.tictactoe.model.Model;
import javafx.scene.input.MouseEvent;

import javax.print.attribute.standard.PDLOverrideSupported;

import static com.example.tictactoe.Position.*;

public class Controller {

    Model model = new Model();

    public void initialize() {
    }

    public Model getModel() {
        return model;
    }

    public void positionOneClicked (MouseEvent mouseEvent) {
        model.selectedPosition(FIRST);
    }
    public void positionTwoClicked (MouseEvent mouseEvent) {
        model.selectedPosition(SECOND);
    }
    public void positionThreeClicked (MouseEvent mouseEvent) {
        model.selectedPosition(THIRD);
    }
    public void positionFourClicked (MouseEvent mouseEvent) {
        model.selectedPosition(FOURTH);
    }
    public void positionFiveClicked (MouseEvent mouseEvent) {
        model.selectedPosition(FIFTH);
    }
    public void positionSixthClicked (MouseEvent mouseEvent) {
        model.selectedPosition(SIXTH);
    }
    public void positionSeventhClicked (MouseEvent mouseEvent) {
        model.selectedPosition(SEVENTH);
    }
    public void positionEighthClicked (MouseEvent mouseEvent) {
        model.selectedPosition(EIGHTH);
    }
    public void positionNinthClicked (MouseEvent mouseEvent) {
        model.selectedPosition(NINTH);
    }



}