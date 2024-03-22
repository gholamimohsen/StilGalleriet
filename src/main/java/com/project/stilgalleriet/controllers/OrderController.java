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

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @PostMapping
    public ResponseEntity<?>createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        try {
            Order newOrder = orderService.createOrder(orderDTO);
            return ResponseEntity.ok(newOrder);
        } catch (EntityNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse>orders =orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<List<OrderResponse>> getOrderById(@PathVariable String id) {
        List<OrderResponse> orders = orderService.getOrderById(id);
        return ResponseEntity.ok(orders);
    }


    // update order by id
    @PutMapping("/{id}")
    public  ResponseEntity<Order> updateOrder (@PathVariable String id, @Valid @RequestBody Order orderDetails){
        Order updateOrder = orderService.updateOrder(id, orderDetails);
        return  ResponseEntity.ok(updateOrder);

    }
    // Endpoint to delete an Order by  Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder (@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Deleted Order: " +id+ " has been deleted " );

    }

}

