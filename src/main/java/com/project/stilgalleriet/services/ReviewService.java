package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    //Create a new review
    public Review addReview(Review review){
        return reviewRepository.save(review);
    }

    //Get all reviews, can have it for testing CRUD not sure if needed later on
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    //Get reviews by seller user ID, implemented later as Order need to be functional

    //Update a review
    public Review updateReview(String id, Review updatedReview){
        return reviewRepository.findById(id)
                .map(review -> {
                    if (updatedReview.getRating() != null){
                        review.setRating(updatedReview.getRating());
                    }
                    if (updatedReview.getComment() != null){
                        review.setComment(updatedReview.getComment());
                    }
                    return reviewRepository.save(review);
                })
                .orElseThrow(); //Add exception handling
    }

    //Delete review
    public void deleteReview(String id){
        reviewRepository.deleteById(id);
    }

}
