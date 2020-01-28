package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// -Dspring.profiles.active=test
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext("com.example.config");
		container.close();
	}
}
