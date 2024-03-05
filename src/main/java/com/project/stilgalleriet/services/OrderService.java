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

    public Order updateOrder(String id, Order updatedOrder){

        //No exception handling added!
        return orderRepository.findById(id)
                .map(order -> {

                    /*Have to consider what you can update in Order, for example don't think IDs should be updated.
                    This time I just use all the setters, to quickly finish this.
                    */
                    order.setSellerUserId(updatedOrder.getSellerUserId());
                    order.setBuyerUserId(updatedOrder.getBuyerUserId());
                    order.setAdvertisementId(updatedOrder.getAdvertisementId());
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setQuantity(updatedOrder.getQuantity());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    order.setSold(updatedOrder.isSold());


                    return orderRepository.save(order);

                })
                .orElseThrow();
    }

    // Method to delete an Order by its ID
    public void  deleteOrder(String id) {
        orderRepository.deleteById(id);



    }
}
