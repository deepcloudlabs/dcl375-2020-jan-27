package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.imdb.service.MovieService;

public class App {
	public static void main(String[] args) {
      ConfigurableApplicationContext container =
		new ClassPathXmlApplicationContext("beans.xml");
      container.getBean(MovieService.class)
               .findAllMoviesByYearRangeAndGenre(
            		   "Drama", 1970, 1979)
               .forEach(System.out::println);
      container.close();
	}
}
