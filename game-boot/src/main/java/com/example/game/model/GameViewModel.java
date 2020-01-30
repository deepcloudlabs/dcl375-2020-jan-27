package com.example.game.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@SessionScope
public class GameViewModel {
    private int secret;
    private int tries;
    private List<Move> moves;

    public List<Move> getMoves() {
        return moves;
    }

    @PostConstruct
    public void initGame() {
        secret = ThreadLocalRandom.current()
                .nextInt(100) + 1;
        moves = new ArrayList<>();
        tries = 0;
    }

    public void play(int guess) {
        tries++;
        if (guess == secret) {
            //TODO: update statistics
            initGame();
        } else {
            if (tries >= 7) {
                //TODO: update statistics
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

    private String createMessage(int guess) {
        if (guess < secret) return "Pick larger!";
        return "Pick smaller!";
    }
}
