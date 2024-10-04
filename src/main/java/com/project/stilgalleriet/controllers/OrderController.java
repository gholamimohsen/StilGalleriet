package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.exception.EntityNotFoundException;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.payload.response.OrderResponse;
import com.project.stilgalleriet.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling Order-related HTTP requests
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        try {
            // Call the service layer to create a new order from the given OrderDTO
            // This abstracts the business logic into the service layer
            Order newOrder = orderService.createOrder(orderDTO);
            // Return a 200 OK response with the newly created order in the response body
            return ResponseEntity.ok(newOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        // Call the service to fetch the order with the given ID
        OrderResponse orders = orderService.getOrderById(id);
        // Return the order details in the response body with HTTP 200 OK
        return ResponseEntity.ok(orders);
    }

    // update order by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @Valid @RequestBody Order orderDetails) {
        try {
            // Call the service to update the order details
            Order updateOrder = orderService.updateOrder(id, orderDetails);
            // Return the updated order in the response body with HTTP 200 OK
            return ResponseEntity.ok(updateOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
        // Endpoint to delete an Order by  Id
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteOrder (@PathVariable String id){
        try {
            // Call the service to delete the order
            orderService.deleteOrder(id);
            // Return a success message indicating that the order has been deleted
            return ResponseEntity.ok("Deleted Order: " + id + " has been deleted ");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    }

