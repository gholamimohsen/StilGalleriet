package com.project.stilgalleriet.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @DBRef
    private User ratingUserId;

    @DBRef
    private User ratedUserId;

    @Min(value = 1, message = "Minimum is 1") @Max(value = 10, message = "10 is the highest")
    private int rating;

    private String comment; //This field should be optional, if reviewer wants to comment

    @CreatedDate
    private Date createdAt;

    public Review(){

    }

    public String getId() {
        return id;
    }

    public User getRatingUserId() {
        return ratingUserId;
    }

    public void setRatingUserId(User ratingUserId) {
        this.ratingUserId = ratingUserId;
    }

    public User getRatedUserId() {
        return ratedUserId;
    }

    public void setRatedUserId(User ratedUserId) {
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

    public Date getCreatedAt() {
        return createdAt;
    }
}
