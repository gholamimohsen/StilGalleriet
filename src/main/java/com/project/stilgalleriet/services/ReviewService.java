package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.ReviewAdd;
import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.ReviewRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    //Create a new review
    public Review addReview(ReviewAdd reviewAdd){

        //Change to input DTO object that contains(IDs as string)

        //Check if user already made review

        //Check if user is eligible for making a review(See if an order match the seller and buyer ids)

        Optional<User> ratingUser = Optional.of(userRepository.findById(reviewAdd.getRatingUserId())).orElseThrow(() -> new RuntimeException("User not found"));
        Optional<User> ratedUser = Optional.of(userRepository.findById(reviewAdd.getRatedUserId()).orElseThrow(() -> new RuntimeException("User not found")));

        Review review = new Review();

        review.setRatingUserId(ratingUser.get());
        review.setRatedUserId(ratedUser.get());

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

                    //Validation annotations in model already check this value, we don't need to check it here
                    review.setRating(updatedReview.getRating());

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

    public List<Review> getReviewBySeller(String ratedId){
        return reviewRepository.findByRatedUserId(ratedId);
    }

}
