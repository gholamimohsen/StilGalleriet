package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    //Create a new review
    public Review addReview(Review review){
        return reviewRepository.save(review);
    }

}
