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
    Random random;

    public Model (Random random) {
        this.random = random;
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

        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
    }

    public GameState getGameState() {
        return gameState;
    }

    public ListProperty<Image> imagesProperty() {
        return images;
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

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
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
            if (currentPlayer.equals(PLAYER1)) {
                images.set(0, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(0, circle);
            }
        }
        else if (position == SECOND && images.get(1) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(1, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(1, circle);
            }
        }
        else if (position == THIRD && images.get(2) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(2, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(2, circle);
            }
        }
        else if (position == FOURTH && images.get(3) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(3, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(3, circle);
            }
        }
        else if (position == FIFTH && images.get(4) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(4, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(4, circle);
            }
        }
        else if (position == SIXTH && images.get(5) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(5, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(5, circle);
            }
        }
        else if (position == SEVENTH && images.get(6) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(6, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(6, circle);
            }
        }
        else if (position == EIGHTH && images.get(7) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(7, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(7, circle);
            }
        }
        else if (position == NINTH && images.get(8) == empty) {
            if (currentPlayer.equals(PLAYER1)) {
                images.set(8, cross);
            }
            else if (currentPlayer.equals(NPC)) {
                images.set(8, circle);
            }
        }

        availablePositions.removeIf(pos->pos.equals(position));
        checkWinning();
        switchPlayer();
    }

    private void switchPlayer() {
        if (currentPlayer.equals(PLAYER1)) {
            currentPlayer = NPC;
        }
        else if (currentPlayer.equals(NPC)) {
            currentPlayer = PLAYER1;
        }
    }

    public void checkWinning() {
        if (winningConditionsCross()) {
            addScore();
        } else if (winningConditionsCircle()) {
            addScore();
        } else {
            addScore();
        }
    }

    private void addScore() {
        if (winningConditionsCross()) {
            score1++;
            setScorePlayer1(score1 + " points");
            setResult("Player 1 Wins!");
            gameState = GAME_OVER;
        } else if (winningConditionsCircle()) {
            score2++;
            setScorePlayer2(score2 + " points");
            setResult("Player 2 Wins!");
            gameState = GAME_OVER;
        } else if (getAvailablePositions().isEmpty()) {
            setResult("Drawn!");
            gameState = GAME_OVER;
        }
    }

    public boolean winningConditionsCross() {
        return (checkRows(cross) || checkColumns(cross) || checkDiagonal(cross));
    }

    public boolean winningConditionsCircle() {
        return (checkRows(circle) || checkColumns(circle) || checkDiagonal(circle));
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
        for (int i = 0; i < 9; i++) {
            images.add(i, empty);
        }
        currentPlayer = randomizeStartingPlayer();
        availablePositions.addAll(Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH));
        setResult("");
        gameState = RUNNING;
    }
}
