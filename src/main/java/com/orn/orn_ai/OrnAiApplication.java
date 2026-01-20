package com.orn.orn_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OrnAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrnAiApplication.class, args);
	}

}
