package com.demo.heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.demo.heroes")
public class HeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesApplication.class, args);
	}
}
