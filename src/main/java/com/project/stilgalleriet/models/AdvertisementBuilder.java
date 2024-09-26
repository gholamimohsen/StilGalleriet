package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "advertisements")
public class AdvertisementBuilder {
    @Id
    private String id;

    @DBRef
    private User userId;
    private String title;
    private String description;

    private AdvertisementBuilder(Builder builder)
    {
        this.userId = builder.userId;
        this.title = builder.title;
        this.description = builder.description;
    }

    public static Builder builder(User userId, String title)
    {
        return new Builder(userId, title);
    }

    public User getUserId()
    {
        return userId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }


    public static class Builder
    {
        private User userId;
        private String title;
        private String description;


        public Builder(User userId, String title){
            this.userId = userId;
            this.title = title;
        }


        public Builder description(String description){
            this.description = description;
            return this;
        }


        public AdvertisementBuilder build(){
        return new AdvertisementBuilder(this);
        }
    }
}
