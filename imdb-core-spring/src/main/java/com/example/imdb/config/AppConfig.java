package com.example.imdb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
	"com.example.imdb.service.business"	
})
@PropertySource({
	"classpath:database.properties",
	"classpath:security.properties"
})
public class AppConfig {
	@Value("${db.hostname}")
	private String hostname;
	@Value("${db.port}")
	private int port;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.name:mysql}")
	private String databaseName;
	@PostConstruct
	public void init() {
		System.out.println(username + ":" + password
				+ "@" + hostname + ":" + port);
		System.out.println(databaseName);
	}
}
