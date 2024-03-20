package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.exception.EntityNotFoundExeception;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.payload.response.OrderResponse;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    // Dependency on OrderRepository
    @Autowired
     OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdvertisementRepository advertisementRepository;

    public Order createOrder(OrderDTO orderDTO) {
        // check that buyer exists in db
        User buyer = userRepository.findById(orderDTO.getBuyerUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        // check that the ad exists in db
        Advertisement advertisement = advertisementRepository.findById(orderDTO.getAdvertisementId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid advertisement id"));
        Order order = new Order();
        // set buyer
        order.setBuyerUserId(buyer);
        // set ad
        order.setAdvertisementId(advertisement);
        order.setSellerUserId(advertisement.getUser());

        return orderRepository.save(order);
    }

    // Method to retrieve all  Orders
    public List<OrderResponse> getAllOrders() {
        List<Order> orders= orderRepository.findAll();
        return  orders.stream().map(this::convertToDTO).collect(Collectors.toList());

    }
    // Method to find an Order by its ID
    public List<OrderResponse> getOrderById(String id){
        Optional<Order> orders =orderRepository.findById(id);

        //If the order is not found, throw an exception that results in a 404 Not Found response
        if (orders.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with ID " + id + " not found.");
        }
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

   private OrderResponse convertToDTO(Order order) {
       OrderDTO orderDTO = new OrderDTO();
       orderDTO.setBuyerUserId(order.getBuyerUserId().getId());
       orderDTO.setAdvertisementId(order.getAdvertisementId().getId());
       return orderDTO ;

    }




    public Order updateOrder(String id, Order updatedOrder){
        return orderRepository.findById(id)
                .map(order -> {
                    //Have to consider what you can update in Order, for example don't think IDs should be updated.
                    order.setSellerUserId(updatedOrder.getSellerUserId());
                    order.setBuyerUserId(updatedOrder.getBuyerUserId());
                    order.setAdvertisementId(updatedOrder.getAdvertisementId());
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setQuantity(updatedOrder.getQuantity());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    order.setSold(updatedOrder.isSold());


                    return orderRepository.save(order);

                })
                .orElseThrow(()-> new EntityNotFoundExeception(Order.class,id));
    }

    // Method to delete an Order by its ID
    public void  deleteOrder(String id) {
        orderRepository.deleteById(id);



    }
}
