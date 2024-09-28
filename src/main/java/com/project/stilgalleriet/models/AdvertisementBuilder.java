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

    private double price;

    private AdvertisementBuilder(Builder builder)
    {
        this.userId = builder.userId;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
    }

    public static UserIdSetter builder()
    {
        return new Builder();
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

    public double getPrice()
    {
        return price;
    }

    //Interface chaining
    public interface UserIdSetter
    {
        TitleSetter userId(User userId);
    }

    public interface TitleSetter
    {
        OptionalFieldsSetter title(String title);
    }

    public interface OptionalFieldsSetter
    {
        OptionalFieldsSetter description(String description);
        OptionalFieldsSetter price(double price);

        AdvertisementBuilder build();
    }

    public static class Builder implements UserIdSetter, TitleSetter, OptionalFieldsSetter
    {
        private User userId;
        private String title;
        private String description;
        private double price;


        @Override
        public Builder userId(User userId){
            this.userId = userId;
            return this;
        }
        @Override
        public Builder title(String title)
        {
            this.title = title;
            return this;
        }

        @Override
        public Builder description(String description){
            this.description = description;
            return this;
        }
        @Override
        public Builder price(double price)
        {
            this.price = price;
            return this;
        }

        public AdvertisementBuilder build(){
        return new AdvertisementBuilder(this);
        }
    }
}
