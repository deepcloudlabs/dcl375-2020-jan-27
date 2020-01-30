package com.example.game.controller;

import com.example.game.model.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
@RequestMapping("play")
public class GameController {
    @Autowired
    private GameViewModel game;

    @ModelAttribute("game")
    public GameViewModel getGame() {
        return game;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String play(int guess) {
        game.play(guess);
        return "home";
    }
}
