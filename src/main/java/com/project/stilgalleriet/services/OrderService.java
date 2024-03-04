package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    // Dependency on OrderRepository
    private final OrderRepository orderRepository;

    // Constructor to inject OrderRepository dependency
    @Autowired
    public OrderService (OrderRepository orderRepository){
        this.orderRepository =orderRepository;
    }

    // Method to add a new Order

     public Order addOrder(@Valid Order order) {
        return orderRepository.save(order);

    }

    // Method to retrieve all  Orders
    public List<Order> findAllOrders() {
        return orderRepository.findAll();

    }

    // Method to find an Order by its ID
    public Optional<Order> findOrderById(String id) {
        return orderRepository.findById(id);
    }

    // Method to update an existing Order
    public Order updateOrder(String id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));

        // Update fields with data from orderDetails
        order.setSellerUserId(orderDetails.getSellerUserId());
        order.setSellerUserId(orderDetails.getSellerUserId());
        order.setAdvertisementId(orderDetails.getAdvertisementId());
        order.setOrderDate(orderDetails.getOrderDate());
        order.setQuantity(orderDetails.getQuantity());
        order.setTotalPrice(orderDetails.getTotalPrice());
        order.setUpdatedAt(orderDetails.getUpdatedAt());
        order.setSold(orderDetails.isSold());


        return orderRepository.save(order);

    }
    // Method to delete an Order by its ID
    public void  deletOrder(String id) {
        Order order= orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));
        orderRepository.delete(order);


    }
}
