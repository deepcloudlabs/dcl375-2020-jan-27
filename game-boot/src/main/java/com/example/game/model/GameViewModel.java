package com.example.game.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
@SessionScope
public class GameViewModel {
    private int secret;
    private int tries;
    private long start;
    private List<Move> moves;
    @Autowired
    private GameStatistics statistics;

    public List<Move> getMoves() {
        return moves;
    }

    @PostConstruct
    public void initGame() {
        secret = ThreadLocalRandom.current()
                .nextInt(100) + 1;
        moves = new ArrayList<>();
        start = System.currentTimeMillis();
        tries = 0;
    }

    public void play(int guess) {
        checkMove(guess);
        tries++;
        if (guess == secret) {
            long stop = System.currentTimeMillis();
            statistics.updateWinStatistics(tries, TimeUnit.MILLISECONDS.toSeconds(stop - start));
            initGame();
        } else {
            if (tries >= 7) {
                statistics.updateLoseStatistics();
                Move move = new Move(secret, "You have lost!");
                initGame();
                moves.add(move);
            } else {
                String message = createMessage(guess);
                Move move = new Move(guess, message);
                moves.add(move);
            }
        }

    }

    private void checkMove(int guess) {
        for (Move move : moves) {
            if (guess == move.getGuess())
                throw new IllegalArgumentException(
                        "You have already entered " + guess);
        }
    }

    private String createMessage(int guess) {
        if (guess < secret) return "Pick larger!";
        return "Pick smaller!";
    }
}
