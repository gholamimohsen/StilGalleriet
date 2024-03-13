package com.project.stilgalleriet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class ReviewDTO { //DTO for Reviews. Used for both request and response.
    private String ratingUserId; //Can grab this ID somehow with authentication or being logged in(user account)?

    private String ratedUserId;

    @Min(value = 1, message = "Minimum is 1") @Max(value = 10, message = "10 is the highest")
    private int rating;

    private String comment;

    public String getRatingUserId() {
        return ratingUserId;
    }

    public void setRatingUserId(String ratingUserId) {
        this.ratingUserId = ratingUserId;
    }

    public String getRatedUserId() {
        return ratedUserId;
    }

    public void setRatedUserId(String ratedUserId) {
        this.ratedUserId = ratedUserId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
