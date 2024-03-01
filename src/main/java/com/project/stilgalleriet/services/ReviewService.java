package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    //Create a new review
    public Review addReview(Review review){
        return reviewRepository.save(review);
    }

    //Get all reviews
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    //Find review by ID
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
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

    //Check if rating field input within range of rating(1-10)
    public boolean isWithinRange(byte rating){
        return rating < 1 || rating > 10;
    }
}
