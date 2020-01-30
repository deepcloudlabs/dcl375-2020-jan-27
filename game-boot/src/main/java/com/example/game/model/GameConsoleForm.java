package com.example.game.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class GameConsoleForm {
    @Min(1)
    @Max(100)
    private int guess;
    private String errorMessage;

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
