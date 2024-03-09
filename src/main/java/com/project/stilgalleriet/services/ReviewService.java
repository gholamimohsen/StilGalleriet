package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.ReviewDTO;
import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.ReviewRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    //Create a new review, takes DTO as input
    public Review addReview(ReviewDTO reviewDTO){

        //Check if user already made review(Can be done with exception handling)

        //Check if user is eligible for making a review(See if an order match the seller id)
        //Might need custom query for Order similar to the one in getReviewBySeller

        //Use User ID strings from DTO to get User objects to feed into Review object
        Optional<User> ratingUser = Optional.of(userRepository.findById(reviewDTO.getRatingUserId())).orElseThrow(() -> new RuntimeException("User not found"));
        Optional<User> ratedUser = Optional.of(userRepository.findById(reviewDTO.getRatedUserId()).orElseThrow(() -> new RuntimeException("User not found")));

        //Insert values into Review object
        Review review = new Review();

        review.setRatingUserId(ratingUser.get());
        review.setRatedUserId(ratedUser.get());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());

        //Return and save Review object
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

    //Show all reviews for a seller(ratedUserId)
    public List<ReviewDTO> getReviewBySeller(String id){
        List<Review> reviews = reviewRepository.findByRatedUserId(id);
        return reviews.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    //Convert Review object to ReviewDTO object
    private ReviewDTO convertToDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setRatingUserId(review.getRatingUserId().getId());
        reviewDTO.setRatedUserId(review.getRatedUserId().getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());

        return reviewDTO;
    }

}
