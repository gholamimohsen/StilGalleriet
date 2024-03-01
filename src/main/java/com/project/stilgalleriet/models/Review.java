package com.project.stilgalleriet.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    private String ratingUserId; //Add @DBRef after other CRUD are done

    private String ratedUserId; //Add @DBRef after other CRUD are done

    @NotBlank(message = "Please enter a number from 1 to 10 for your rating")
    private byte rating;

    private String comment; //This field should be optional, if reviewer wants to comment

    @CreatedDate
    private Date createdAt;

    public Review(){

    }

    public String getId() {
        return id;
    }

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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
