package com.project.stilgalleriet.services;

import com.project.stilgalleriet.Mappers.ReviewMapper;
import com.project.stilgalleriet.dto.ReviewDTO;
import com.project.stilgalleriet.exception.EntityNotFoundException;
import com.project.stilgalleriet.models.Order;
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
    public ReviewDTO createReview(ReviewDTO reviewDTO){

        //Check if user already made review(Can be done with exception handling)


        //Checks if order exists and if transaction is done(isSold = true). If false throws exception
        if(isOrderDone(reviewDTO)) {

            //Use User ID strings from DTO to get User objects to feed into Review object
            Optional<User> ratingUser = Optional.of(userRepository.findById(reviewDTO.getRatingUserId())).orElseThrow(() -> new RuntimeException("User not found"));
            Optional<User> ratedUser = Optional.of(userRepository.findById(reviewDTO.getRatedUserId()).orElseThrow(() -> new RuntimeException("User not found")));

            //Insert values into Review object
            Review review = new Review();

            review.setRatingUserId(ratingUser.get());
            review.setRatedUserId(ratedUser.get());
            review.setRating(reviewDTO.getRating());
            review.setComment(reviewDTO.getComment());

            //Save Review object and return DTO as response
            reviewRepository.save(review);
           // return convertToDTO(review);
            return ReviewMapper.toDto(review);
        }
        else throw new EntityNotFoundException("You are not eligible to review this user");
    }
    // Get all reviews
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get review by ID
    public ReviewDTO getReviewById(String id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with ID: " + id));
        return ReviewMapper.toDto(review);
    }


    //Update a review
    public ReviewDTO updateReview(String id, Review updatedReview){

         return reviewRepository.findById(id)
                .map(review -> {

                    //Validation annotations in DTO already check this value, we don't need to check it here
                    review.setRating(updatedReview.getRating());

                    if (updatedReview.getComment() != null){
                        review.setComment(updatedReview.getComment());
                    }
                    reviewRepository.save(review);

                    //Create ReviewDTO object to return as response
                    return ReviewMapper.toDto(review);
                })
                .orElseThrow(() -> new EntityNotFoundException("Review not found with ID: " + id)); //Add exception handling

    }

    //Delete review
    public void deleteReview(String id){
        reviewRepository.deleteById(id);
    }

    // Get reviews by seller (rated user ID)
    public List<ReviewDTO> getReviewBySeller(String id) {
        return reviewRepository.findByRatedUserId(id)
                .stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
    }


    //Method for checking if user have finished purchase by checking if order exist.
    private boolean isOrderDone(ReviewDTO reviewDTO){
        try {
            Order order = orderRepository.findOrderByBuyerUserIdAndSellerUserId(reviewDTO.getRatingUserId(), reviewDTO.getRatedUserId());
            return order.isSold();
        } catch (NullPointerException e){
            return false;
        }
    }

}
