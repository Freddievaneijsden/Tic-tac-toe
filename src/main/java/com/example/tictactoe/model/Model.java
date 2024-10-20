package com.example.tictactoe.model;

import com.example.tictactoe.Position;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;


public class Model {

    private int score1 = 0;
    private int score2 = 0;
    private StringProperty scorePlayer1 = new SimpleStringProperty("0 points");
    private StringProperty scorePlayer2 = new SimpleStringProperty("0 points");
    Image circle;
    Image cross;
    Image empty;

    public String getScorePlayer1() {
        return scorePlayer1.get();
    }

    public StringProperty scorePlayer1Property() {
        return scorePlayer1;
    }

    public void setScorePlayer1(String scorePlayer1) {
        this.scorePlayer1.set(scorePlayer1);
    }

    public String getScorePlayer2() {
        return scorePlayer2.get();
    }

    public StringProperty scorePlayer2Property() {
        return scorePlayer2;
    }

    public void setScorePlayer2(String scorePlayer2) {
        this.scorePlayer2.set(scorePlayer2);
    }

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
        circle = new Image(getClass().getResource("/com/example/tictactoe/images/Circle.png").toExternalForm());
        cross = new Image(getClass().getResource("/com/example/tictactoe/images/Cross.png").toExternalForm());
        empty = new Image(getClass().getResource("/com/example/tictactoe/images/Empty.png").toExternalForm());
        firstPosition = new SimpleObjectProperty<>(empty);
        secondPosition = new SimpleObjectProperty<>(empty);
        thirdPosition = new SimpleObjectProperty<>(empty);
        fourthPosition = new SimpleObjectProperty<>(empty);
        fifthPosition = new SimpleObjectProperty<>(empty);
        sixthPosition = new SimpleObjectProperty<>(empty);
        seventhPosition = new SimpleObjectProperty<>(empty);
        eighthPosition = new SimpleObjectProperty<>(empty);
        ninthPosition = new SimpleObjectProperty<>(empty);
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
        if (position == Position.FIRST && getFirstPosition() == empty)
            setFirstPosition(cross);
        else if (position == Position.SECOND && getSecondPosition() == empty)
            setSecondPosition(cross);
        else if (position == Position.THIRD && getThirdPosition() == empty)
            setThirdPosition(cross);
        else if (position == Position.FOURTH && getFourthPosition() == empty)
            setFourthPosition(cross);
        else if (position == Position.FIFTH && getFifthPosition() == empty)
            setFifthPosition(cross);
        else if (position == Position.SIXTH && getSixthPosition() == empty)
            setSixthPosition(cross);
        else if (position == Position.SEVENTH && getSeventhPosition() == empty)
            setSeventhPosition(cross);
        else if (position == Position.EIGHTH && getEighthPosition() == empty)
            setEighthPosition(cross);
        else if (position == Position.NINTH && getNinthPosition() == empty)
            setNinthPosition(cross);

       // setScorePlayer1(score1 + " points");
    }

    public void changePlayer() {
        
    }

    public boolean isWinning() {
        if (getFirstPosition() == cross && getSecondPosition() == cross && getThirdPosition() == cross) {
            score1 ++;
            setScorePlayer1(score1 + " points");
            return true;
        }
        return false;
    }

    public void resetGame () {
        setFirstPosition(empty);
        setSecondPosition(empty);
        setThirdPosition(empty);
        setFourthPosition(empty);
        setFifthPosition(empty);
        setSixthPosition(empty);
        setSeventhPosition(empty);
        setEighthPosition(empty);
        setNinthPosition(empty);
    }
}
