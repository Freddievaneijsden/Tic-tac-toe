package com.example.tictactoe.model;

import com.example.tictactoe.GameState;
import com.example.tictactoe.Players;
import com.example.tictactoe.Position;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.*;

import static com.example.tictactoe.GameState.*;
import static com.example.tictactoe.Players.*;
import static com.example.tictactoe.Position.*;


public class Model {

    private int score1 = 0;
    private int score2 = 0;
    private final StringProperty scorePlayer1 = new SimpleStringProperty("0 points");
    private final StringProperty scorePlayer2 = new SimpleStringProperty("0 points");
    private final StringProperty result = new SimpleStringProperty("");
    private final List<Position> availablePositions = new ArrayList<>();
    private final ListProperty<Image> images = new SimpleListProperty<>(FXCollections.observableArrayList());
    private Players currentPlayer;
    private GameState gameState;
    Image circle;
    Image cross;
    Image empty;


    Random random = new Random();

    public Model() {
        currentPlayer = PLAYER1;
        gameState = RUNNING;
        circle = new Image(getClass().getResource("/com/example/tictactoe/images/Circle.png").toExternalForm());
        cross = new Image(getClass().getResource("/com/example/tictactoe/images/Cross.png").toExternalForm());
        empty = new Image(getClass().getResource("/com/example/tictactoe/images/Empty.png").toExternalForm());

        images.addFirst(empty);
        images.add(1, empty);
        images.add(2, empty);
        images.add(3, empty);
        images.add(4, empty);
        images.add(5, empty);
        images.add(6, empty);
        images.add(7, empty);
        images.add(8, empty);

        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
    }

    public ObservableList<Image> getImages() {
        return images.get();
    }

    public ListProperty<Image> imagesProperty() {
        return images;
    }

    public void setImages(ObservableList<Image> images) {
        this.images.set(images);
    }

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

    public Position npcRandomPosition() {
        Position randomPosition = availablePositions.get(random.nextInt(availablePositions.size()));
        availablePositions.remove(randomPosition);
        return randomPosition;
    }

    public void npcMove() {
        if (currentPlayer.equals(NPC) && gameState.equals(RUNNING)) {
            selectedPosition(npcRandomPosition());
        }
    }

    public void selectedPosition(Position position) {
//        if (gameState.equals(GAME_OVER)) {
//            return;
//        }
        if (position == FIRST && images.getFirst() == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(0, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(0, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == SECOND && images.get(1) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(1, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(1, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == THIRD && images.get(2) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(2, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(2, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == FOURTH && images.get(3) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(3, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(3, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == FIFTH && images.get(4) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(4, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(4, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == SIXTH && images.get(5) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(5, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(5, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == SEVENTH && images.get(6) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(6, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(6, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == EIGHTH && images.get(7) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(7, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(7, circle);
                    currentPlayer = PLAYER1;
                }
            }
        } else if (position == NINTH && images.get(8) == empty) {
            switch (currentPlayer) {
                case PLAYER1 -> {
                    images.set(8, cross);
                    currentPlayer = NPC;
                }
                case NPC -> {
                    images.set(8, circle);
                    currentPlayer = PLAYER1;
                }
            }
        }
        availablePositions.remove(position);
        isWinning();
    }

    public boolean isWinning() {
        if (isCross()) {
            score1++;
            setScorePlayer1(score1 + " points");
            setResult("Player 1 Wins!");
            gameState = GAME_OVER;
            return true;
        } else if (isCircle()) {
            score2++;
            setScorePlayer2(score2 + " points");
            setResult("Player 2 Wins!");
            gameState = GAME_OVER;
            return true;
        } else if (getAvailablePositions().isEmpty()) {
            setResult("Drawn!");
            gameState = GAME_OVER;
            return true;
        }
        return false;
    }

    public boolean isCross() {
        if (checkRows(cross))
            return true;
        else if (checkColumns(cross))
            return true;
        else return checkDiagonal(cross);
    }

    public boolean isCircle() {
        if (checkRows(circle))
            return true;
        else if (checkColumns(circle))
            return true;
        else return checkDiagonal(circle);
    }

    private boolean checkRows(Image image) {
        return (images.get(0) == image && images.get(1) == image && images.get(2) == image)
                || (images.get(3) == image && images.get(4) == image && images.get(5) == image)
                || (images.get(6) == image && images.get(7) == image && images.get(8) == image);
    }

    private boolean checkColumns(Image image) {
        return (images.get(0) == image && images.get(3) == image && images.get(6) == image)
                || (images.get(1) == image && images.get(4) == image && images.get(7) == image)
                || (images.get(2) == image && images.get(5) == image && images.get(8) == image);
    }

    private boolean checkDiagonal(Image image) {
        return ((images.get(0) == image && images.get(4) == image && images.get(8) == image)
                || (images.get(2) == image && images.get(4) == image && images.get(6) == image));
    }

    public void resetGame() {
        images.set(0, empty);
        images.set(1, empty);
        images.set(2, empty);
        images.set(3, empty);
        images.set(4, empty);
        images.set(5, empty);
        images.set(6, empty);
        images.set(7, empty);
        images.set(8, empty);
        currentPlayer = PLAYER1;
        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
        setResult("");
        gameState = RUNNING;
    }
}
