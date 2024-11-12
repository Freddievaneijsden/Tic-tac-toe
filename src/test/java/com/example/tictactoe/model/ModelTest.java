package com.example.tictactoe.model;

import com.example.tictactoe.GameState;
import com.example.tictactoe.Position;
import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.tictactoe.Position.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    //Varje test som körs startar en ny instans av modelTest

    Model model = new Model(new Random()); //If many tests need an object, is created before running tests

    //Runs JavaFX without rendering window before each test
    //Also possible to initialize new JFXPanel() for each test.
    @BeforeAll
    static void runJavaFX() {
        Platform.startup(() -> {
        });
    }

    @Test
    @DisplayName("completeGame")
    void completeGame() {
        Model model = new Model(new FixedRandom());

        model.selectedPosition(THIRD);
        model.selectedPosition(FIRST);
        model.selectedPosition(SIXTH);
        model.selectedPosition(SECOND);
        model.selectedPosition(NINTH);
        model.selectedPosition(SEVENTH);

        assertEquals(model.getResult(), "Player 1 Wins!");
    }

    @Test
    @DisplayName("whenCrossWinsThenAddOneScore")
    void whenCrossWinsThenAddOneScore() {
        Model model = new Model(new FixedRandom());
        int initialScore = model.getScore1();

        model.placeCrossOrCircle(6);
        model.placeCrossOrCircle(7);
        model.placeCrossOrCircle(8);
        model.checkWinning();

        assertThat(model.getScore1()).isEqualTo(initialScore + 1);
    }

    @Test
    @DisplayName("whenCircleWinsThenAddOneScore")
    void whenCircleWinsThenAddOneScore() {
        Model model = new Model(new FixedRandom());
        int initialScore = model.getScore1();

        model.selectedPosition(FIRST);
        model.selectedPosition(THIRD);
        model.selectedPosition(FOURTH);
        model.selectedPosition(SIXTH);
        model.selectedPosition(SECOND);
        model.selectedPosition(NINTH);

        assertThat(model.getScore2()).isEqualTo(initialScore + 1);
    }


    @Test
    @DisplayName("whenThreeCrossInRowThenReturnTrue")
    void whenThreeCrossInRowThenReturnTrue() {

        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(6);
        model.placeCrossOrCircle(7);
        model.placeCrossOrCircle(8);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCrossInSecondRowThenReturnTrue")
    void whenThreeCrossInSecondRowThenReturnTrue() {

        Model model = new Model(new FixedRandom());

        model.selectedPosition(FOURTH);
        model.selectedPosition(FIRST);
        model.selectedPosition(FIFTH);
        model.selectedPosition(SEVENTH);
        model.selectedPosition(SIXTH);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCrossInThirdRowThenReturnTrue")
    void whenThreeCrossInThirdRowThenReturnTrue() {

        Model model = new Model(new FixedRandom());

        model.selectedPosition(SEVENTH);
        model.selectedPosition(FIRST);
        model.selectedPosition(EIGHTH);
        model.selectedPosition(SECOND);
        model.selectedPosition(NINTH);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenPartialMatchInFirstRowThenReturnFalse")
    void whenPartialMatchInFirstRowThenReturnFalse() {
        Model model = new Model(new FixedRandom());

        // Arrange: Set the first two images in the first row to match crossOrCircle
        model.selectedPosition(FIRST);
        model.selectedPosition(SIXTH);// Set images[0] to crossOrCircle
        model.selectedPosition(SECOND);  // Set images[1] to crossOrCircle

        // Act: Leave images[2] as empty or with a different symbol
        boolean result = model.winningConditionsCross();  // This will invoke checkRows and should return false

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("whenPartialMatchInSecondRowThenReturnFalse")
    void whenPartialMatchInSecondRowThenReturnFalse() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(0);
        model.placeCrossOrCircle(1);
        model.placeCrossOrCircle(3);
        model.placeCrossOrCircle(4);

        assertFalse(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCrossInColumnThenReturnTrue")
    void whenThreeCrossInColumnThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(0);
        model.placeCrossOrCircle(3);
        model.placeCrossOrCircle(6);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCrossInSecondColumnThenReturnTrue")
    void whenThreeCrossInSecondColumnThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(1);
        model.placeCrossOrCircle(4);
        model.placeCrossOrCircle(7);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCrossInThirdColumnThenReturnTrue")
    void whenThreeCrossInThirdColumnThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(2);
        model.placeCrossOrCircle(5);
        model.placeCrossOrCircle(8);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenPartialMatchInTSecondColumnThenReturnFalse")
    void whenPartialMatchInSecondColumnThenReturnFalse() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(1);
        model.placeCrossOrCircle(4);

        assertFalse(model.winningConditionsCross());
    }


    @Test
    @DisplayName("whenThreeCrossInDiagonalThenReturnTrue")
    void whenThreeCrossInDiagonalThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.placeCrossOrCircle(0);
        model.placeCrossOrCircle(4);
        model.placeCrossOrCircle(8);

        assertTrue(model.winningConditionsCross());
    }

    @Test
    @DisplayName("whenThreeCircleInRowThenReturnTrue")
    void whenThreeCircleInRowThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.selectedPosition(EIGHTH);
        model.placeCrossOrCircle(3);
        model.placeCrossOrCircle(4);
        model.placeCrossOrCircle(5);

        assertTrue(model.winningConditionsCircle());
    }

    @Test
    @DisplayName("whenThreeCircleInSecondRowThenReturnTrue")
    void whenThreeCircleInSecondRowThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.selectedPosition(EIGHTH);
        model.selectedPosition(SECOND);
        model.selectedPosition(FOURTH);
        model.selectedPosition(THIRD);
        model.selectedPosition(FIRST);
        model.selectedPosition(SIXTH);
        model.selectedPosition(SEVENTH);
        model.selectedPosition(NINTH);


        assertTrue(model.winningConditionsCircle());
    }

    @Test
    @DisplayName("whenThreeCircleInColumnThenReturnTrue")
    void whenThreeCircleInColumnThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.selectedPosition(NINTH);
        model.placeCrossOrCircle(1);
        model.placeCrossOrCircle(4);
        model.placeCrossOrCircle(7);

        assertTrue(model.winningConditionsCircle());
    }

    @Test
    @DisplayName("whenThreeCircleInDiagonalThenReturnTrue")
    void whenThreeCircleInDiagonalThenReturnTrue() {
        Model model = new Model(new FixedRandom());

        model.selectedPosition(EIGHTH);
        model.placeCrossOrCircle(2);
        model.placeCrossOrCircle(4);
        model.placeCrossOrCircle(6);

        assertTrue(model.winningConditionsCircle());
    }

    @Test
    @DisplayName("whenPositionIsFilledThenUnableToAddNewImage")
    void whenPositionIsFilledThenUnableToAddNewImage() {
        //Arrange
        model.selectedPosition(FIRST);

        //Áct
        Image initialImage = model.imagesProperty().getFirst();
        model.selectedPosition(FIRST);

        //Assert
        assertEquals(initialImage, model.imagesProperty().getFirst());
    }


    @Test
    @DisplayName("whenOutOfAvailablePositionsThenGameOver")
    void whenOutOfAvailablePositionsThenGameOver() {
        model.selectedPosition(FIRST);
        model.selectedPosition(SECOND);
        model.selectedPosition(THIRD);
        model.selectedPosition(FOURTH);
        model.selectedPosition(FIFTH);
        model.selectedPosition(SIXTH);
        model.selectedPosition(SEVENTH);
        model.selectedPosition(EIGHTH);
        model.selectedPosition(NINTH);

        assertTrue(model.getAvailablePositions().isEmpty());

    }

    @Test
    @DisplayName("whenOutOfAllAvailablePositionsThenResetGame")
    void whenOutOfAllAvailablePositionsThenResetGame() {
        List<Position> availablePositions = new ArrayList<>(model.getAvailablePositions());
        model.selectedPosition(FIRST);
        model.selectedPosition(SECOND);
        model.selectedPosition(THIRD);
        model.selectedPosition(FOURTH);
        model.selectedPosition(FIFTH);
        model.selectedPosition(SIXTH);
        model.selectedPosition(SEVENTH);
        model.selectedPosition(EIGHTH);
        model.selectedPosition(NINTH);

        model.resetGame();
        List<Position> resetPositions = new ArrayList<>(model.getAvailablePositions());
        GameState running = model.getGameState();

        assertEquals(availablePositions, resetPositions);
        assertEquals(running, model.getGameState());


    }

//    @Test
//    void whenListOfAvailablePositionsIsCreatedThenContainAllNinePositions() {
//
//        var result = model.getAvailablePositions();
//        assertThat(result)
//                .containsExactly(FIRST, SECOND, THIRD,
//                        FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH,
//                        NINTH);
//
//    }

    //Kolla listor i test
    //var result = model.getLista, kan därefter assert (3, result.size).

    //Med assertAll() får man exception på samtliga test som failar, annars visas bara fram till då exception kastades


}