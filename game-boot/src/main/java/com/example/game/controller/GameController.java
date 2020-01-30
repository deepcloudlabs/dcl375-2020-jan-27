package com.example.game.controller;

import com.example.game.model.GameConsoleForm;
import com.example.game.model.GameStatistics;
import com.example.game.model.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

import static java.util.stream.Collectors.joining;

@Controller
@RequestScope
@RequestMapping("play")
@Validated
@SessionAttributes({"game", "statistics"})
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
            HttpServletRequest req,
            @Validated @ModelAttribute("console")
                    GameConsoleForm form, BindingResult result) {
        System.out.println(req.getSession().getId());
        //req.getSession().invalidate();
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
