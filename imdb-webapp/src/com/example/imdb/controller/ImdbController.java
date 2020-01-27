package com.example.imdb.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.imdb.entity.Movie;
import com.example.imdb.model.CriteriaBean;
import com.example.imdb.service.MovieService;

@WebServlet(urlPatterns = "/search")
public class ImdbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private MovieService movieSrv;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CriteriaBean criteria = new CriteriaBean();
		Integer from = Integer.parseInt(request.getParameter("from"));
		criteria.setFromYear(from);
		Integer to = Integer.parseInt(request.getParameter("to"));
		criteria.setToYear(to);
		criteria.setYearRangeSelected(true);
		Integer genreId = Integer.parseInt(request.getParameter("genreId"));
		criteria.setGenre(genreId);
		criteria.setGenreSelected(true);
		Collection<Movie> movies = movieSrv.findAllMoviesByCriteria(criteria);
		criteria.setMovies(movies);
		request.setAttribute("imdb", criteria);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
