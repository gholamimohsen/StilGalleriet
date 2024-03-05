package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    // Dependency on OrderRepository
    @Autowired
     OrderRepository orderRepository;

    // Method to add a new Order
    public Order addOrder(Order order) {
        return orderRepository.save(order);

    }

    // Method to retrieve all  Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    // Method to find an Order by its ID
    public Optional<Order> getOrderById(String id){
        return orderRepository.findById(id);
    }

    // Method to update an existing Order
    public Order updateOrder(String id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));
        return orderRepository.save(updatedOrder);
    }

    // Method to delete an Order by its ID
    public void  deleteOrder(String id) {
        orderRepository.deleteById(id);



    }
}
