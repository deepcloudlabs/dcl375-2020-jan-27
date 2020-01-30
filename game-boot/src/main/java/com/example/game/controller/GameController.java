package com.example.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("play")
public class GameController {
    @GetMapping
    public String home(){ return "home";}
}
