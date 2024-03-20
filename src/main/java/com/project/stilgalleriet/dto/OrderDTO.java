package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.payload.response.OrderResponse;

public class OrderDTO extends OrderResponse {

    private String buyerUserId;

    private String advertisementId;



    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }



}