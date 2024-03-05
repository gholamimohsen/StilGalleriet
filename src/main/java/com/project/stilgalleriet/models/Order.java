package com.project.stilgalleriet.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String SellerUserId;
    private String buyersUserId;
    private String advertisementId;
    private Date orderDate;
    private int quantity;
    private BigDecimal totalPrice;
    private boolean isSold;
    private Date createdAt;
    private Date updatedAt;


    //Constructors, getters, and setters
    public Order() {
    }

    public String getSellerUserId() {
        return SellerUserId;
    }

    public void setSellerUserId(String sellerUserId) {
        SellerUserId = sellerUserId;
    }

    public String getBuyersUserId() {
        return buyersUserId;
    }

    public void setBuyersUserId(String buyersUserId) {
        this.buyersUserId = buyersUserId;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
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


}

