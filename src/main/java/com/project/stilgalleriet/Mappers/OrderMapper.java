package com.project.stilgalleriet.Mappers;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.payload.response.OrderResponse;

public class OrderMapper {
    public static OrderResponse toDto(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setBuyerUserId(order.getBuyerUserId() != null ? order.getBuyerUserId().getId() : null);
        orderResponse.setAdvertisementId(order.getAdvertisementId() != null ? order.getAdvertisementId().getId() : null);
        orderResponse.setSellerUserId(order.getSellerUserId() != null ? order.getSellerUserId().getId() : null);
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setSold(order.isSold());
        orderResponse.setCreatedAt(order.getCreatedAt());
        orderResponse.setUpdatedAt(order.getUpdatedAt());
        return orderResponse;
    }
}

