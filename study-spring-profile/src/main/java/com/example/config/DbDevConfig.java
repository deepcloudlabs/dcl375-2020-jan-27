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
@Profile("dev")
@Configuration
@PropertySource("classpath:database-dev.properties")
public class DbDevConfig {
	@Value("${db.host}")
	private String host;
	@Value("${db.port}")
	private int port;

	@PostConstruct
	public void init() {
		System.out.println(host + ":" + port);
	}
}
