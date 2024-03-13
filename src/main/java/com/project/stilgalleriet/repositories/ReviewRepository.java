package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    //Untested, need to change Review creation service to use DTO
    List<Review> findByRatedUserId(String ratedUser);

}
