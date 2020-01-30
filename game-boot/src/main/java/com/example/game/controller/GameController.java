package com.example.game.controller;

import com.example.game.model.GameConsoleForm;
import com.example.game.model.GameStatistics;
import com.example.game.model.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import static java.util.stream.Collectors.joining;

@Controller
@RequestScope
@RequestMapping("play")
@Validated
public class GameController {
    @Autowired
    private GameViewModel game;
    @Autowired
    private GameStatistics statistics;

    @ModelAttribute("game")
    public GameViewModel getGame() {
        return game;
    }

    @ModelAttribute("statistics")
    public GameStatistics getStatistics() {
        return statistics;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String play(
            @Validated @ModelAttribute("console")
                    GameConsoleForm form, BindingResult result) {
        if (result.hasErrors()) {
            String errMsg = result.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(joining("|"));
            form.setErrorMessage(errMsg);
        } else {
            try {
                game.play(form.getGuess());
            } catch (Exception e) {
                form.setErrorMessage(e.getMessage());
            }
        }
        return "home";
    }
}
