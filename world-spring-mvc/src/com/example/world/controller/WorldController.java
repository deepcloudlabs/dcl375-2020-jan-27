package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.world.dao.CountryDao;
import com.example.world.entity.Country;

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

	@GetMapping
	public String home(Model model) {
		Set<String> continents = countryDao.getAllContinents();
		model.addAttribute("continents", continents);
		return "home";
	}
	@PostMapping
	public String list(Model model,String continent) {
		List<Country> countries = 
				countryDao.findCountriesByContinent(
						continent);
		model.addAttribute("countries", countries);
		Set<String> continents = countryDao.getAllContinents();
		model.addAttribute("continents", continents);
		return "home";
	}
}
