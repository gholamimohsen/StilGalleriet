package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.models.ECategory;
import com.project.stilgalleriet.models.EColor;
import com.project.stilgalleriet.models.EGender;
import com.project.stilgalleriet.models.ESize;

import java.util.Date;
import java.util.List;

public class AdvertisementDTO {

    private String userId;
    private String advertisementId;
    private String advertisementTitles;
    private String advertisementDescriptions;
    private EGender advertisementGender;
    private ECategory advertisementCategory;
    private List <String> advertisementImgUrls;
    private ESize advertisementSize;
    private EColor advertisementColor;
    private double advertisementPrice;
    private Date advertisementDate;
    private Date advertisementUpdatedDate;
    private boolean advertisementIsActive;

    public AdvertisementDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdvertisementTitles() {
        return advertisementTitles;
    }

    public void setAdvertisementTitles(String advertisementTitles) {
        this.advertisementTitles = advertisementTitles;
    }

    public String getAdvertisementDescriptions() {
        return advertisementDescriptions;
    }

    public void setAdvertisementDescriptions(String advertisementDescriptions) {
        this.advertisementDescriptions = advertisementDescriptions;
    }

    public EGender getAdvertisementGender() {
        return advertisementGender;
    }

    public void setAdvertisementGender(EGender advertisementGender) {
        this.advertisementGender = advertisementGender;
    }

    public ECategory getAdvertisementCategory() {
        return advertisementCategory;
    }

    public void setAdvertisementCategory(ECategory advertisementCategory) {
        this.advertisementCategory = advertisementCategory;
    }

    public List<String> getAdvertisementImgUrls() {
        return advertisementImgUrls;
    }

    public void setAdvertisementImgUrls(List<String> advertisementImgUrls) {
        this.advertisementImgUrls = advertisementImgUrls;
    }

    public ESize getAdvertisementSize() {
        return advertisementSize;
    }

    public void setAdvertisementSize(ESize advertisementSize) {
        this.advertisementSize = advertisementSize;
    }

    public EColor getAdvertisementColor() {
        return advertisementColor;
    }

    public void setAdvertisementColor(EColor advertisementColor) {
        this.advertisementColor = advertisementColor;
    }

    public double getAdvertisementPrice() {
        return advertisementPrice;
    }

    public void setAdvertisementPrice(double advertisementPrice) {
        this.advertisementPrice = advertisementPrice;
    }

    public Date getAdvertisementDate() {
        return advertisementDate;
    }

    public void setAdvertisementDate(Date advertisementDate) {
        this.advertisementDate = advertisementDate;
    }

    public Date getAdvertisementUpdatedDate() {
        return advertisementUpdatedDate;
    }

    public void setAdvertisementUpdatedDate(Date advertisementUpdatedDate) {
        this.advertisementUpdatedDate = advertisementUpdatedDate;
    }

    public boolean isAdvertisementIsActive() {
        return advertisementIsActive;
    }

    public void setAdvertisementIsActive(boolean advertisementIsActive) {
        this.advertisementIsActive = advertisementIsActive;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }
}
