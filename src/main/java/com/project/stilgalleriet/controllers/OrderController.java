package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controller class for handling Order-related HTTP requests

@RestController
@RequestMapping("/stilgalleriet/orders")
public class OrderController {

    @Autowired
    private  OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order){
        Order newOrder =orderService.addOrder(order);
        return  new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
    // Endpoint to get all Orders
    @GetMapping
    public List<Order>getAllOrder(){
        return orderService.getAllOrders();

    }
    // Endpoint to get an Order by its id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable String id){
        Optional<Order> order = orderService.getOrderById(id);
        return  order.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
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

