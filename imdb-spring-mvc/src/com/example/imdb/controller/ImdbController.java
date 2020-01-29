package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.entity.Genre;
import com.example.imdb.model.CriteriaBean;
import com.example.imdb.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Controller
@RequestScope
@RequestMapping("search")
public class ImdbController {
	@Autowired
	private MovieService movieSrv;

	@ModelAttribute("genres")
	public Collection<Genre> genres() {
		return movieSrv.findAllGenres();
	}

	@GetMapping
	public String home() {
		return "home";
	}
	@PostMapping
	public String search(@ModelAttribute("imdb") CriteriaBean criteria) {
		criteria.setMovies(movieSrv.findAllMoviesByCriteria(criteria));
		return "home";
	}
}
