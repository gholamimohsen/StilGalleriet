package com.project.stilgalleriet.dto;

public class ReviewAdd {
    private String ratingUserId;

    private String ratedUserId;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
