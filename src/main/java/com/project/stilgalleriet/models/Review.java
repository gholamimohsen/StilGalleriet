package com.project.stilgalleriet.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @Min(value = 1, message = "Minimum is 1") @Max(value = 10, message = "10 is the highest")
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

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
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
