package com.project.stilgalleriet.exception;

import com.project.stilgalleriet.models.Order;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class<Order> orderClass, String id) {
    }
}
