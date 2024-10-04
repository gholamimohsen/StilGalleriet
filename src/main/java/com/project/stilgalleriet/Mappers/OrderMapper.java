package com.project.stilgalleriet.Mappers;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.payload.response.OrderResponse;

public class OrderMapper {
    // Converts an Order entity into an OrderResponse DTO
    //The purpose of this method is to transform an Order entity into an OrderResponse DTO.
    // to decouple the internal entity structure from external layers like the API layer.
    public static OrderResponse toDto(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        // Set buyerUserId, if available; otherwise, set to null
        orderResponse.setBuyerUserId(order.getBuyerUserId() != null ? order.getBuyerUserId().getId() : null);
        // Set advertisementId, if available; otherwise, set to null
        orderResponse.setAdvertisementId(order.getAdvertisementId() != null ? order.getAdvertisementId().getId() : null);
        // Set sellerUserId, if available; otherwise, set to null
        orderResponse.setSellerUserId(order.getSellerUserId() != null ? order.getSellerUserId().getId() : null);
        // Set the order date
        orderResponse.setOrderDate(order.getOrderDate());
        // Set the quantity of items in the order
        orderResponse.setQuantity(order.getQuantity());
        // Set the total price of the order
        orderResponse.setTotalPrice(order.getTotalPrice());
        // Indicate if the order has been marked as sold
        orderResponse.setSold(order.isSold());
        // Set the created date of the order
        orderResponse.setCreatedAt(order.getCreatedAt());
        // Set the last updated date of the order
        orderResponse.setUpdatedAt(order.getUpdatedAt());
        return orderResponse; // Return the populated OrderResponse DTO
    }
}


