package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.config.AppConfig;
import com.example.imdb.service.MovieService;
// -Ddb.username=produser -Ddb.port=4040
public class App {
	public static void main(String[] args) {
      ConfigurableApplicationContext container =
		//new ClassPathXmlApplicationContext("beans-min.xml");
        new AnnotationConfigApplicationContext(
        		AppConfig.class);  
    container.getBean(MovieService.class)
               .findAllMoviesByYearRangeAndGenre(
            		   "Drama", 1970, 1979)
               .forEach(System.out::println);
      container.close();
	}
}
