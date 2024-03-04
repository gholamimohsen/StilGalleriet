package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling Order-related HTTP requests
@RequestMapping("/api/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    // Constructor to inject OrderService dependency
    @Autowired
    public OrderController (OrderService orderService){
        this.orderService =orderService;
    }

    // Endpoint to add a new Order
    @PostMapping
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order){
        Order newOrder = orderService.addOrder(order);
        return  new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }


    // Endpoint to get all Orders
    @GetMapping
    public  ResponseEntity <List<Order>> getAllOrder(){
        List<Order> orders = orderService.findAllOrders();
        return  new ResponseEntity<>(orders, HttpStatus.OK);

    }
    // Endpoint to get an Order by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable String id){
        return orderService.findOrderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing Order
    @PutMapping("/{id}")
    public  ResponseEntity<Order> updateOrder (@PathVariable String id, @Valid @RequestBody Order orderDetails){
        Order updateOrder = orderService.updateOrder(id, orderDetails);
        return  ResponseEntity.ok(updateOrder);

    }
    // Endpoint to delete an Order by its ID
    @DeleteMapping("/{id}")
    public  ResponseEntity<Valid> deletOrder (@PathVariable String id) {
        orderService.deletOrder(id);
        return ResponseEntity.noContent().build();
    }

}

