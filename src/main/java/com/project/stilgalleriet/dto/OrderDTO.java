package com.project.stilgalleriet.dto;

import com.project.stilgalleriet.payload.response.OrderResponse;
import jakarta.validation.constraints.NotNull;

// OrderDTO class extends OrderResponse, meaning it inherits properties and methods from OrderResponse.
// This class is used to transfer order data between layers (DTO: Data Transfer Object).
public class OrderDTO extends OrderResponse {
    // Field representing the ID of the buyer user.
    // The @NotNull annotation ensures that this field cannot be null when creating or updating an order.
    // If the field is null, a validation message "Buyer user ID cannot be null" will be triggered.
    @NotNull(message = "Buyer user ID cannot be null")
    private String buyerUserId;
    // Field representing the ID of the advertisement associated with the order.
    // Similar to buyerUserId, this field cannot be null, and the @NotNull annotation provides validation.
    @NotNull(message = "Advertisement ID cannot be null")
    private String advertisementId;

    //Getter method Allows other classes to retrieve the buyer's user ID associated with this order.
    public String getBuyerUserId() {
        return buyerUserId;
    }
    // Allows other classes to set or modify the buyer's user ID for this order.
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