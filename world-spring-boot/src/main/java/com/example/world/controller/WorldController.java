package com.example.world.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.world.repository.CountryRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Controller
@RequestMapping("list")
public class WorldController {
	@Autowired
	private CountryRepository countryRepository;

	@ModelAttribute("continents")
	public Set<String> getAllContinents() {
		return countryRepository.getAllContinents();
	}

	@GetMapping
	public String home() {
		return "home";
	}

	@PostMapping
	public ModelAndView list(ModelAndView mv, String continent) {
		mv.setViewName("home");
		mv.getModelMap().addAttribute("countries", countryRepository.findByContinent(continent));
		return mv;
	}
}
