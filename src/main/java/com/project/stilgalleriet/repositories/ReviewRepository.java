package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    //Does not work if DBRef is applied to field(ratedUserId)
    List<Review> findByRatedUserId(String id);

}
