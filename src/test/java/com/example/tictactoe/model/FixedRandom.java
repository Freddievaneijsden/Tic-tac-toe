package com.example.tictactoe.model;

import java.util.Random;

public class FixedRandom extends Random {
    int bound = 0;

    @Override
    public int nextInt(int bound) {
        bound = 0;
        return bound;
    }
}
