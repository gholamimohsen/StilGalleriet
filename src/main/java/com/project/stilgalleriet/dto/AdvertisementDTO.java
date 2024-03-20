package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.models.ECategory;
import com.project.stilgalleriet.models.EColor;
import com.project.stilgalleriet.models.EGender;
import com.project.stilgalleriet.models.ESize;

import java.util.Date;
import java.util.List;

public class AdvertisementDTO {
    private String sellerId;
    private String adId;
    private String adTitles;
    private String adDescriptions;
    private EGender adGender;
    private ECategory adCategory;
    private List<String> adImgUrls;
    private ESize adSize;
    private EColor adColor;
    private double adPrice;
    private Date adDate;
    private Date adUpdatedDate;
    private boolean adIsActive;


    public AdvertisementDTO() {
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

    public String getAdTitles() {
        return adTitles;
    }

    public void setAdTitles(String adTitles) {
        this.adTitles = adTitles;
    }

    public String getAdDescriptions() {
        return adDescriptions;
    }

    public void setAdDescriptions(String adDescriptions) {
        this.adDescriptions = adDescriptions;
    }

    public EGender getAdGender() {
        return adGender;
    }

    public void setAdGender(EGender adGender) {
        this.adGender = adGender;
    }

    public ECategory getAdCategory() {
        return adCategory;
    }

    public void setAdCategory(ECategory adCategory) {
        this.adCategory = adCategory;
    }

    public List<String> getAdImgUrls() {
        return adImgUrls;
    }

    public void setAdImgUrls(List<String> adImgUrls) {
        this.adImgUrls = adImgUrls;
    }

    public ESize getAdSize() {
        return adSize;
    }

    public void setAdSize(ESize adSize) {
        this.adSize = adSize;
    }

    public EColor getAdColor() {
        return adColor;
    }

    public void setAdColor(EColor adColor) {
        this.adColor = adColor;
    }

    public double getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(double adPrice) {
        this.adPrice = adPrice;
    }

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    public Date getAdUpdatedDate() {
        return adUpdatedDate;
    }

    public void setAdUpdatedDate(Date adUpdatedDate) {
        this.adUpdatedDate = adUpdatedDate;
    }

    public boolean isAdIsActive() {
        return adIsActive;
    }

    public void setAdIsActive(boolean adIsActive) {
        this.adIsActive = adIsActive;
    }
}