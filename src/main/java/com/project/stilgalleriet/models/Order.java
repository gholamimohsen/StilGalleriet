package com.project.stilgalleriet.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    @DBRef
    private User sellerUserId;
    @DBRef
    private User buyerUserId;
    @DBRef
    private Advertisement advertisementId;
    //private List<Advertisement> advertisementId;
    @CreatedDate
    private Date orderDate; //Might consider removing this in the future if same as createdAt
    private int quantity;
    private double totalPrice;
    private boolean isSold;

    @CreatedDate
    private Date createdAt;

    private Date updatedAt;


    //Constructors, getters, and setters
    public Order() {
    }

    public String getId() {
        return id;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    public User getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(User sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public User getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(User buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Advertisement getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Advertisement advertisementId) {
        this.advertisementId = advertisementId;
    }

    public void setId(String id) {
        this.id = id;
    }

   /* public List<Advertisement> getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(List<Advertisement> advertisementId) {
        this.advertisementId = advertisementId;
    }*/
}