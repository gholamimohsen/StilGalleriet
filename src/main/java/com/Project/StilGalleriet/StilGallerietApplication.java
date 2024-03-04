package com.Project.StilGalleriet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class StilGallerietApplication {

	public static void main(String[] args) {
		SpringApplication.run(StilGallerietApplication.class, args);
	}

}
