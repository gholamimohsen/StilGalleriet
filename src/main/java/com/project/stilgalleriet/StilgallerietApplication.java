package com.project.stilgalleriet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class StilgallerietApplication {

	public static void main(String[] args) {
		SpringApplication.run(StilgallerietApplication.class, args);
	}

}
