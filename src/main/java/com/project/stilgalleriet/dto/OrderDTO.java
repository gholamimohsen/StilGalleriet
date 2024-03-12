package com.project.stilgalleriet.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String sellerUserId;
    private String buyerUserId;
    private List<String> advertisementId;
    private int quantity;
    private BigDecimal totalPrice;
    private Date orderedDate;


    public String getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(String sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public List<String> getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(List<String> advertisementId) {
        this.advertisementId = advertisementId;
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



   // public String getUserId() {
      //  return getUserId();/

    }
