package com.example.game.model;

public class Move {
    private final int guess;
    private final String message;

    public Move(int guess, String message) {
        this.guess = guess;
        this.message = message;
    }
    //region getters
    public int getGuess() {
        return guess;
    }

    public String getMessage() {
        return message;
    }
    //endregion

    @Override
    public String toString() {
        return "Move{" +
                "guess=" + guess +
                ", message='" + message + '\'' +
                '}';
    }
}
