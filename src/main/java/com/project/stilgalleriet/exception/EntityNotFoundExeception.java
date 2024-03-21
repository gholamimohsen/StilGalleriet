package com.project.stilgalleriet.exception;

import com.project.stilgalleriet.models.Order;

public class EntityNotFoundExeception extends  RuntimeException{
    public  EntityNotFoundExeception (Class<Order> orderClass, String message) {
        super(message);
    }


    public EntityNotFoundExeception(String sellerNotFoundForAdvertisement) {
    }
}
