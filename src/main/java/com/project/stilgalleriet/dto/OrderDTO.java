package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.payload.response.OrderResponse;
import jakarta.validation.constraints.NotNull;

public class OrderDTO extends OrderResponse {

    @NotNull(message = "Buyer user ID cannot be null")
    private String buyerUserId;

    @NotNull(message = "Advertisement ID cannot be null")
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