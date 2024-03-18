package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByRatedUserId(String ratedUser);

}
