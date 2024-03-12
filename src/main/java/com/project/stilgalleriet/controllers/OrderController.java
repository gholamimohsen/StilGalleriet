package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.dto.OrderResponse;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling Order-related HTTP requests

@RestController
@RequestMapping("/stilgalleriet/orders")
public class OrderController {

    @Autowired
    private  OrderService orderService;

    // Inside OrderController

    /*private OrderResponse convertToOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        //sellerUserId and buyerUserId are supposed to be the IDs of User entities
        response.setSellerUserId(order.getSellerUserId().getId());
        response.setBuyerUserId(order.getBuyerUserId().getId());
        List<String> advertisementId = order.getAdvertisementId().stream()
                .map(Advertisement::getId)
                .collect(Collectors.toList());
        response.setAdvertisementId(advertisementId);
        response.setQuantity(order.getQuantity());
        response.setTotalPrice(order.getTotalPrice());
        response.setOrderDate(order.getOrderDate());
        response.setSold(order.isSold());
        response.setCreatedAt(order.getCreatedAt());
        response.setUpdatedAt(order.getUpdatedAt());

        return response;
    }*/

    @PostMapping
    public ResponseEntity<Order>addOrder(@Valid @RequestBody OrderDTO orderDTO){
        Order newOrder= orderService.addOrder(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse>orders =orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<List<OrderResponse>> getOrderById(@PathVariable String id){
        List<OrderResponse> orders = orderService.getOrderById(id);
        return ResponseEntity.ok(orders);

    }
   /* public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody OrderDTO orderDTO){
        Order newOrder =orderService.addOrder(orderDTO);
        OrderResponse response = convertToOrderResponse(newOrder);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Endpoint to get all Orders
    @GetMapping
    public ResponseEntity<List<OrderResponse>>getAllOrder(){
        List<Order> orders = orderService.getAllOrders();
        List<OrderResponse> responses = orders.stream()
                .map(this::convertToOrderResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);

    }
    // Endpoint to get an Order by its id
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id){
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        OrderResponse response = convertToOrderResponse(order);
        return ResponseEntity.ok(response);
    }*/

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

