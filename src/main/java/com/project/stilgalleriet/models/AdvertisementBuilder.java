package com.project.stilgalleriet.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document(collection = "advertisements")
public class AdvertisementBuilder {
    @Id
    private String id;

    @DBRef
    private final User userId;
    private final String title;
    private final String description;
    private final double price;
    private final List<String> images;
    private final ECategory category;
    private final EColor color;
    private final EGender gender;
    private final ESize size;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate //No idea if this is what I think it is and how it works
    private Date updatedAt;
    private boolean isActive;

    private AdvertisementBuilder(Builder builder)
    {
        this.userId = builder.userId;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.images = builder.images;
        this.category = builder.category;
        this.color = builder.color;
        this.gender = builder.gender;
        this.size = builder.size;
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

    public List<String> getImages()
    {
        return images;
    }

    public ECategory getCategory()
    {
        return category;
    }

    public EColor getColor()
    {
        return color;
    }

    public EGender getGender()
    {
        return gender;
    }
    public ESize getSize() {
        return size;
    }

    //Interface chaining
    //Want to try setting required fields after set category. For example shoes must have shoe size.
    public interface UserIdSetter //Set so you must have userId and title, have to test this properly
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

        OptionalFieldsSetter images(List<String> images);

        OptionalFieldsSetter category(ECategory category);
        OptionalFieldsSetter color(EColor color);
        OptionalFieldsSetter gender(EGender gender);

        OptionalFieldsSetter size(ESize size);

        AdvertisementBuilder build();
    }

    public static class Builder implements UserIdSetter, TitleSetter, OptionalFieldsSetter
    {
        private User userId;
        private String title;
        private String description;
        private double price;
        private List<String> images = Collections.emptyList();
        private ECategory category;
        private EColor color;
        private EGender gender;
        private ESize size;

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

        @Override
        public Builder images(List<String> images)
        {
            this.images = images;
            return this;
        }
        @Override
        public Builder category(ECategory category)
        {
            this.category = category;
            return this;
        }
        @Override
        public Builder color(EColor color)
        {
            this.color = color;
            return this;
        }
        @Override
        public Builder gender(EGender gender)
        {
            this.gender = gender;
            return this;
        }

        public Builder size(ESize size) {
            this.size = size;
            return this;
        }

        public AdvertisementBuilder build()
        {
        return new AdvertisementBuilder(this);
        }
    }
}
