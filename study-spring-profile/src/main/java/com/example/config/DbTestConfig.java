package com.example.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Profile("test")
@Configuration
@PropertySource("classpath:database-test.properties")
public class DbTestConfig {
	@Value("${db.host}")
	private String host;
	@Value("${db.port}")
	private int port;

	@PostConstruct
	public void init() {
		System.out.println(host + ":" + port);
	}
}
