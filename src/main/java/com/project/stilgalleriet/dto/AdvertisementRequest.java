package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.models.ECategory;
import com.project.stilgalleriet.models.EColor;
import com.project.stilgalleriet.models.EGender;
import com.project.stilgalleriet.models.ESize;

import java.util.Date;
import java.util.List;

public class AdvertisementRequest {
    private String sellerId;
    private String adId;
    private String title;
    private String description;
    private EGender gender;
    private ECategory category;
    private List<String> images;
    private ESize size;
    private EColor color;
    private double price;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;


    public AdvertisementRequest() {
    }


    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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
        this.isActive = active;
    }
}