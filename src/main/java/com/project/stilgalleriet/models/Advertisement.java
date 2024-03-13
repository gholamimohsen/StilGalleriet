package com.project.stilgalleriet.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection="advertisement")
public class Advertisement {

    @Id
    private String id;


    @DBRef
    @NotBlank(message="Field can not be blank")
    private User userId;

    @NotBlank(message="Field can not be blank")
    private String title;

    @NotBlank(message="Field can not be blank")
    private String description;


    @NotBlank(message="Field can not be blank")
    private EGender gender;


    @NotBlank(message="Field can not be blank")
    private ECategory category;

    @NotEmpty(message="Field can not be empty")
    private List<String > imgUrl;


    @NotBlank(message="Field can not be blank")
     private ESize size;

    @NotBlank(message="Field can not be blank")
     private EColor color;

    @NotBlank(message="Field can not be blank")
     private double price;


     private Date createdAt=new Date();


     private Date updatedAt=new Date();

     private boolean isActive=true;


    public Advertisement() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ESize getSize() {
        return size;
    }

    public void setSize(ESize size) {
        this.size = size;
    }

    public EColor getColor() {
        return color;
    }

    public void setColor(EColor color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
