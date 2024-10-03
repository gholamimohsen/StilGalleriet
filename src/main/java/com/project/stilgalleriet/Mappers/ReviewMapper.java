package com.project.stilgalleriet.Mappers;

import com.project.stilgalleriet.dto.ReviewDTO;
import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.models.User;

public class ReviewMapper {
    public static ReviewDTO toDto(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setRatingUserId(review.getRatingUserId().getId());
        reviewDTO.setRatedUserId(review.getRatedUserId().getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        return reviewDTO;
    }

    public static Review toEntity(ReviewDTO reviewDTO, User ratingUser, User ratedUser) {
        Review review = new Review();
        review.setRatingUserId(ratingUser);
        review.setRatedUserId(ratedUser);
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        return review;
    }
}
