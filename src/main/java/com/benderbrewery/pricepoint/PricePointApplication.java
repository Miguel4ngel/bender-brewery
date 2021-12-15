package com.benderbrewery.pricepoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.benderbrewery.data.entity" })
@EnableJpaRepositories("com.benderbrewery.data.repository")
@ComponentScan(basePackages = { "com.benderbrewery.presentation.controller", "com.benderbrewery.domain.service", "com.benderbrewery.domain.mapper",
		"com.benderbrewery.presentation.advisor", "com.benderbrewery.data.connector.currency",  "com.benderbrewery.domain.util" })
public class PricePointApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricePointApplication.class, args);
	}

}
