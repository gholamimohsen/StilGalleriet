package com.project.stilgalleriet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
<<<<<<< HEAD
@EnableMongoAuditing  // Security. Hjälper till att automatiskt fylla i vissa fält i våra databasposter varje gång en post skapas eller ändras.(tex @LastModifiedBy, @CreatedBy)
=======
@EnableMongoAuditing
>>>>>>> ed0691802cd1e6420d81554ddc6e30c5bb1bf14a
public class StilgallerietApplication {

	public static void main(String[] args) {
		SpringApplication.run(StilgallerietApplication.class, args);
	}

}
