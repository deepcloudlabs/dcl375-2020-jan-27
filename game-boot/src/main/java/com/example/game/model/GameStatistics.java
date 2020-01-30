package com.example.game.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class GameStatistics {
    private int wins;
    private int loses;
    private int total;
    private int totalWinMoves;
    private double avgWinMoves;
    private long totalWinTime;
    private double avgWinTime;

    public GameStatistics() {
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getTotal() {
        return wins + loses;
    }

    public double getAvgWinMoves() {
        if (wins == 0) return Double.NaN;
        return totalWinMoves / wins;
    }

    public double getAvgWinTime() {
        if (wins == 0) return Double.NaN;
        return totalWinTime / wins;
    }

    public void updateWinStatistics(int moves, long seconds) {
        wins++;
        totalWinMoves += moves;
        totalWinTime += seconds;
    }

    public void updateLoseStatistics() {
        loses++;
    }
}
