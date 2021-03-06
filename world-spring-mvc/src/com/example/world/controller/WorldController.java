package com.example.world.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.world.dao.CountryDao;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Controller
@RequestMapping("list")
public class WorldController {
	@Autowired
	private CountryDao countryDao;

	@ModelAttribute("continents")
	public Set<String> getAllContinents() {
		return countryDao.getAllContinents();
	}

	@GetMapping
	public String home() {
		return "home";
	}

	@PostMapping
	public ModelAndView list(ModelAndView mv, String continent) {
		mv.setViewName("home");
		mv.getModelMap().addAttribute("countries", countryDao.findCountriesByContinent(continent));
		return mv;
	}
}
