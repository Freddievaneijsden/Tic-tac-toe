package com.example.tictactoe.model;

import com.example.tictactoe.Players;
import com.example.tictactoe.Position;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.*;

import static com.example.tictactoe.Players.*;
import static com.example.tictactoe.Position.*;


public class Model {
    Random random  = new Random();

    private int score1 = 0;
    private int score2 = 0;
    private final StringProperty scorePlayer1 = new SimpleStringProperty("0 points");
    private final StringProperty scorePlayer2 = new SimpleStringProperty("0 points");
    private StringProperty result = new SimpleStringProperty("");
    private List<Position> availablePositions = new ArrayList<>();
    private Players currentPlayer;
    private int moveCount = 0;
    Image circle;
    Image cross;
    Image empty;

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public void setResult(String result) {
        this.result.set(result);
    }

    public List<Position> getAvailablePositions() {
        return availablePositions;
    }

    public Players getCurrentPlayer() {
        return currentPlayer;
    }

    public int getMoveCount() {
        return moveCount;
    }

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
        currentPlayer = PLAYER1;
        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
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

    public Position npcRandomPosition() {
        Position randomPosition = availablePositions.get(random.nextInt(availablePositions.size()));
        availablePositions.remove(randomPosition);
        return randomPosition;
    }

    public void npcMove () {
        if (currentPlayer == NPC) {
            selectedPosition(npcRandomPosition());
        }
    }

//    public void printAvailablePositions() {
//        System.out.println(availablePositions);
//    }

    public void selectedPosition(Position position) {
        if (position == FIRST && getFirstPosition() == empty) {
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setFirstPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setFirstPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == SECOND && getSecondPosition() == empty) {
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setSecondPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setSecondPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == THIRD && getThirdPosition() == empty) {
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setThirdPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setThirdPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == FOURTH && getFourthPosition() == empty) {
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setFourthPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setFourthPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == FIFTH && getFifthPosition() == empty) {
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setFifthPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setFifthPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == SIXTH && getSixthPosition() == empty){
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setSixthPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setSixthPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == SEVENTH && getSeventhPosition() == empty){
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setSeventhPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setSeventhPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == EIGHTH && getEighthPosition() == empty){
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setEighthPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setEighthPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        else if (position == NINTH && getNinthPosition() == empty){
            moveCount ++;
            switch (currentPlayer) {
                case PLAYER1 -> {
                    setNinthPosition(cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    setNinthPosition(circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        availablePositions.remove(position);

        if (isWinning()) {
            resetGame();
            }
//        } else if (getMoveCount() == 9) {
//            setResult("Drawn!");
//            resetGame();
//        }
    }


    public boolean isWinning () {
        if (checkCrossRows() || checkCrossColumns() || checkCrossDiagonal()) {
            score1 ++;
            setScorePlayer1(score1 + " points");
            setResult("Player 1 Wins!");
            return true;
        }
        else if (checkCircleRows() || checkCircleColumns() || checkCircleDiagonal()) {
            score2 ++;
            setScorePlayer2(score2 + " points");
            setResult("Player 2 Wins!");
            return true;
        }
        else if (getMoveCount() == 9) {
            setResult("Drawn!");
            return true;
        }
        return false;
    }

    private boolean checkCircleColumns() {
        return (getFirstPosition() == circle && getFourthPosition() == circle && getSeventhPosition() == circle)
                || (getSecondPosition() == circle && getFifthPosition() == circle && getEighthPosition() == circle)
                || (getThirdPosition() == circle && getSixthPosition() == circle && getNinthPosition() == circle);
    }

    private boolean checkCrossColumns() {
        return (getFirstPosition() == cross && getFourthPosition() == cross && getSeventhPosition() == cross)
                || (getSecondPosition() == cross && getFifthPosition() == cross && getEighthPosition() == cross)
                || (getThirdPosition() == cross && getSixthPosition() == cross && getNinthPosition() == cross);
    }

    private boolean checkCircleRows() {
        return (getFirstPosition() == circle && getSecondPosition() == circle && getThirdPosition() == circle)
                || (getFourthPosition() == circle && getFifthPosition() == circle && getSixthPosition() == circle)
                || (getSeventhPosition() == circle && getEighthPosition() == circle && getNinthPosition() == circle);
    }

    private boolean checkCrossRows() {
        return (getFirstPosition() == cross && getSecondPosition() == cross && getThirdPosition() == cross)
                || (getFourthPosition() == cross && getFifthPosition() == cross && getSixthPosition() == cross)
                || (getSeventhPosition() == cross && getEighthPosition() == cross && getNinthPosition() == cross);
    }

    private boolean checkCrossDiagonal () {
        return ((getFirstPosition() == cross && getFifthPosition() == cross && getNinthPosition() == cross)
        || (getThirdPosition() == cross && getFifthPosition() == cross && getSeventhPosition() == cross));
    }

    private boolean checkCircleDiagonal () {
        return ((getFirstPosition() == circle && getFifthPosition() == circle && getNinthPosition() == circle)
                || (getThirdPosition() == circle && getFifthPosition() == circle && getSeventhPosition() == circle));
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
        moveCount = 0;
        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
        currentPlayer = PLAYER1;

    }
}
