package com.project.stilgalleriet.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "advertisements")
public class AdvertisementBuilder {
    @Id
    private String id;

    @DBRef
    private User userId;
    private String title;
    private String description;

    private EGender gender;

    private ECategory category;

    private List<String > imgUrl;

    private ESize size;

    private EColor color;

    private double price;
    @CreatedDate
    private Date createdAt;

    private Date updatedAt=new Date();

    private boolean isActive=true;

    //No annotations in builder in case, not sure how it would interact.
    public static class Builder
    {
        private User userId;
        private String title;
        private String description;
        private EGender gender;

        /* Start testing with fewer fields
        private ECategory category;
        private List<String > imgUrl;
        private ESize size;
        private EColor color;
        private double price;
        private Date createdAt;
        private Date updatedAt;
        private boolean isActive;


         */
        public Builder(User userId, String title){
            this.userId = userId;
            this.title = title;
        }


        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder gender(EGender gender){
            this.gender = gender;
            return this;
        }


    }
}
