package com.project.stilgalleriet.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @NotBlank(message = "Field cannot be blank")
    private String ratingUserId; //Add @DBRef after other CRUD are done

    @NotBlank(message = "Field cannot be blank")
    private String ratedUserId; //Add @DBRef after other CRUD are done

    @NotBlank(message = "Field cannot be blank")
    private String rating; //Might need to make an enum for this field

    private String comment; //This field should be optional, if reviewer wants to comment

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
}
