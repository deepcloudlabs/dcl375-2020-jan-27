package com.example.mastermind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({
		"i18n.xml"
})
public class MastermindBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastermindBootApplication.class, args);
	}
}
