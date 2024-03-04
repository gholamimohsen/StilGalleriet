package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
