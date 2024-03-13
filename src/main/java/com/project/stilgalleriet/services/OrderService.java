package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.dto.OrderResponse;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




    // Method to add a new Order
    public Order createOrder(OrderDTO orderDTO) {
       // User seller = userRepository.findById(orderDTO.getSellerUserId())
                //.orElseThrow(() -> new RuntimeException("Invalid seller user id"));

        User buyer = userRepository.findById(orderDTO.getBuyerUserId())
                .orElseThrow(() -> new RuntimeException("Invalid  user id"));

      /*  List<Advertisement> advertisements = orderDTO.getAdvertisementId().stream()
                .map(adId -> advertisementRepository.findById(adId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid advertisement id: " + adId)))
                .collect(Collectors.toList());*/
        Advertisement advertisement = advertisementRepository.findById(orderDTO.getAdvertisementId())
                .orElseThrow(()-> new IllegalArgumentException("Invalid advertisement id"));

        Order order= new Order();
        // since the ad already has a user that is by default the seller of the ad
        // and since I implemented check mon user i ad service no need to check again
        // we can be sure the user exists
        // and we set the seller from the user in the ad

        //order.setSellerUserId(seller);

        order.setBuyerUserId(buyer);
        order.setAdvertisementId(advertisement);
        order.getSellerUserId(advertisement.getUser());
       // order.setQuantity(orderDTO.getQuantity());
        //order.setTotalPrice(orderDTO.getTotalPrice());
        return orderRepository.save(order);
       // Order savedOrder = orderRepository.save(order);
        //return convertToOrderResponse(savedOrder);

    }
   /* private OrderResponse convertToDTO(Order order) {
        return ;
    }*/

    // Method to retrieve all  Orders
    public List<OrderResponse > getAllOrders() {
        List<Order> orders= orderRepository.findAll();
        return  orders.stream()
                .map(this::convertToDTO).collect(Collectors.toList());

    }

    // Method to find an Order by its ID
    public List<OrderResponse> getOrderById(String id){
        Optional<Order> orders =orderRepository.findById(id);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
   /* public OrderResponse getOrderById(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
        return convertToOrderResponse(order);
    }*/


    private OrderResponse convertToDTO(Order order) {
        return convertToDTO(order);
    }

    public Order updateOrder(String id, Order updatedOrder){

        //No exception handling added!
        return orderRepository.findById(id)
                .map(order -> {

                    order.setSellerUserId(updatedOrder.getSellerUserId());
                    order.setBuyerUserId(updatedOrder.getBuyerUserId());
                    order.setAdvertisementId(updatedOrder.getAdvertisementId());
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setQuantity(updatedOrder.getQuantity());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    order.setSold(updatedOrder.isSold());
                    return orderRepository.save(order);

                })
                .orElseThrow(()-> new RuntimeException("Order not found with ID: " + id));

    }

    // Method to delete an Order by its ID
    public void  deleteOrder(String id) {
        orderRepository.deleteById(id);



    }
}
