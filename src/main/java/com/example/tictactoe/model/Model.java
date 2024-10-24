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
    private final List<Position> availablePositions = new ArrayList<>(); //use images array instead.
    private final ListProperty<Image> images = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final List<Players> currentPlayers = new ArrayList<>();
    private Players currentPlayer;
    private GameState gameState;
    Image circle;
    Image cross;
    Image empty;

    Random random = new Random();

    public Model() {
        currentPlayers.addAll(Arrays.asList(PLAYER1, NPC));
        currentPlayer = randomizeStartingPlayer();
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

        ObjectProperty<Players> playerOne = new SimpleObjectProperty<>();
        ObjectProperty<Players> playerNpc = new SimpleObjectProperty<>();

        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
    }

    public ObservableList<Image> getImages() {
        return images.get();
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

    public Players randomizeStartingPlayer() {
        return currentPlayers.get(random.nextInt(currentPlayers.size()));
    }

    public Position generateRandomPositionNPC() {
        return availablePositions.get(random.nextInt(availablePositions.size()));
    }

    public void npcMove() {
        if (currentPlayer.equals(NPC) && gameState.equals(RUNNING)) {
            selectedPosition(generateRandomPositionNPC());
        }
    }

    public void selectedPosition(Position position) {
        if (position == FIRST && images.getFirst() == empty) {
            setCrossOrCircle(0);
        } else if (position == SECOND && images.get(1) == empty) {
            setCrossOrCircle(1);
        } else if (position == THIRD && images.get(2) == empty) {
            setCrossOrCircle(2);
        } else if (position == FOURTH && images.get(3) == empty) {
            setCrossOrCircle(3);
        } else if (position == FIFTH && images.get(4) == empty) {
            setCrossOrCircle(4);
        } else if (position == SIXTH && images.get(5) == empty) {
            setCrossOrCircle(5);
        } else if (position == SEVENTH && images.get(6) == empty) {
            setCrossOrCircle(6);
        } else if (position == EIGHTH && images.get(7) == empty) {
            setCrossOrCircle(7);
        } else if (position == NINTH && images.get(8) == empty) {
            setCrossOrCircle(8);
        }

        availablePositions.removeIf(pos->pos.equals(position));
        isWinning();
        System.out.println(currentPlayer);
    }

    private void setCrossOrCircle(int indexForImage) {
        switch (currentPlayer) {
            case PLAYER1 -> {
                images.set(indexForImage, cross);
                currentPlayer = NPC;
            }
            case NPC -> {
                images.set(indexForImage, circle);
                currentPlayer = PLAYER1;
            }
        }
    }

    public boolean isWinning() {
        if (isCross()) {
            addScore();
            return true;
        } else if (isCircle()) {
            addScore();
            return true;
        } else {
            addScore();
        }
        return false;
    }

    private void addScore() {
        if (isCross()) {
            score1++;
            setScorePlayer1(score1 + " points");
            setResult("Player 1 Wins!");
            gameState = GAME_OVER;
        } else if (isCircle()) {
            score2++;
            setScorePlayer2(score2 + " points");
            setResult("Player 2 Wins!");
            gameState = GAME_OVER;
        } else if (getAvailablePositions().isEmpty()) {
            setResult("Drawn!");
            gameState = GAME_OVER;
        }
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

    private boolean checkRows(Image crossOrCircle) {
        return (images.get(0) == crossOrCircle && images.get(1) == crossOrCircle && images.get(2) == crossOrCircle)
                || (images.get(3) == crossOrCircle && images.get(4) == crossOrCircle && images.get(5) == crossOrCircle)
                || (images.get(6) == crossOrCircle && images.get(7) == crossOrCircle && images.get(8) == crossOrCircle);
    }

    private boolean checkColumns(Image crossOrCircle) {
        return (images.get(0) == crossOrCircle && images.get(3) == crossOrCircle && images.get(6) == crossOrCircle)
                || (images.get(1) == crossOrCircle && images.get(4) == crossOrCircle && images.get(7) == crossOrCircle)
                || (images.get(2) == crossOrCircle && images.get(5) == crossOrCircle && images.get(8) == crossOrCircle);
    }

    private boolean checkDiagonal(Image crossOrCircle) {
        return ((images.get(0) == crossOrCircle && images.get(4) == crossOrCircle && images.get(8) == crossOrCircle)
                || (images.get(2) == crossOrCircle && images.get(4) == crossOrCircle && images.get(6) == crossOrCircle));
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
        currentPlayer = randomizeStartingPlayer();
        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
        setResult("");
        gameState = RUNNING;
    }
}
