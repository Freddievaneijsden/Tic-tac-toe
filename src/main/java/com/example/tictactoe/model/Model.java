package com.example.tictactoe.model;

import com.example.tictactoe.Position;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;


public class Model {

    private int score = 0;
    Image circle;
    Image cross;
    Image empty;

    ObjectProperty<Image> firstPosition;
    ObjectProperty<Image> secondPosition;
    ObjectProperty<Image> thirdPosition;
    ObjectProperty<Image> fourthPosition;
    ObjectProperty<Image> fifthPosition;
    ObjectProperty<Image> sixthPosition;
    ObjectProperty<Image> seventhPosition;
    ObjectProperty<Image> eighthPosition;
    ObjectProperty<Image> ninthPosition;

    public Model() {
        firstPosition = new SimpleObjectProperty<>();
        secondPosition = new SimpleObjectProperty<>();
        thirdPosition = new SimpleObjectProperty<>();
        fourthPosition = new SimpleObjectProperty<>();
        fifthPosition = new SimpleObjectProperty<>();
        sixthPosition = new SimpleObjectProperty<>();
        seventhPosition = new SimpleObjectProperty<>();
        eighthPosition = new SimpleObjectProperty<>();
        ninthPosition = new SimpleObjectProperty<>();
        circle = new Image(getClass().getResource("/com/example/tictactoe/images/Circle.png").toExternalForm());
        cross = new Image(getClass().getResource("/com/example/tictactoe/images/Cross.png").toExternalForm());
        empty = new Image(getClass().getResource("/com/example/tictactoe/images/Empty.png").toExternalForm());
    }

    public Image getFirstPosition() {
        return firstPosition.get();
    }

    public ObjectProperty<Image> firstPositionProperty() {
        return firstPosition;
    }

    public void setFirstPosition(Image firstPosition) {
        this.firstPosition.set(firstPosition);
    }

    public Image getSecondPosition() {
        return secondPosition.get();
    }

    public ObjectProperty<Image> secondPositionProperty() {
        return secondPosition;
    }

    public void setSecondPosition(Image secondPosition) {
        this.secondPosition.set(secondPosition);
    }

    public Image getThirdPosition() {
        return thirdPosition.get();
    }

    public ObjectProperty<Image> thirdPositionProperty() {
        return thirdPosition;
    }

    public void setThirdPosition(Image thirdPosition) {
        this.thirdPosition.set(thirdPosition);
    }

    public Image getFourthPosition() {
        return fourthPosition.get();
    }

    public ObjectProperty<Image> fourthPositionProperty() {
        return fourthPosition;
    }

    public void setFourthPosition(Image fourthPosition) {
        this.fourthPosition.set(fourthPosition);
    }

    public Image getFifthPosition() {
        return fifthPosition.get();
    }

    public ObjectProperty<Image> fifthPositionProperty() {
        return fifthPosition;
    }

    public void setFifthPosition(Image fifthPosition) {
        this.fifthPosition.set(fifthPosition);
    }

    public Image getSixthPosition() {
        return sixthPosition.get();
    }

    public ObjectProperty<Image> sixthPositionProperty() {
        return sixthPosition;
    }

    public void setSixthPosition(Image sixthPosition) {
        this.sixthPosition.set(sixthPosition);
    }

    public Image getSeventhPosition() {
        return seventhPosition.get();
    }

    public ObjectProperty<Image> seventhPositionProperty() {
        return seventhPosition;
    }

    public void setSeventhPosition(Image seventhPosition) {
        this.seventhPosition.set(seventhPosition);
    }

    public Image getEighthPosition() {
        return eighthPosition.get();
    }

    public ObjectProperty<Image> eighthPositionProperty() {
        return eighthPosition;
    }

    public void setEighthPosition(Image eighthPosition) {
        this.eighthPosition.set(eighthPosition);
    }

    public Image getNinthPosition() {
        return ninthPosition.get();
    }

    public ObjectProperty<Image> ninthPositionProperty() {
        return ninthPosition;
    }

    public void setNinthPosition(Image ninthPosition) {
        this.ninthPosition.set(ninthPosition);
    }

    public void selectedPosition(Position position) {
    }
}
