package com.project.stilgalleriet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing  // Security. Hjälper till att automatiskt fylla i vissa fält i våra databasposter varje gång en post skapas eller ändras.(tex @LastModifiedBy, @CreatedBy)
public class StilgallerietApplication {

	public static void main(String[] args) {
		SpringApplication.run(StilgallerietApplication.class, args);
	}

}
