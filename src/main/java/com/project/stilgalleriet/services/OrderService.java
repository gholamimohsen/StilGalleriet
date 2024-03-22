package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.exception.EntityNotFoundException;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.payload.response.OrderResponse;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
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
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public Order createOrder(OrderDTO orderDTO) {
        logger.debug("Creating order for buyerId: {} and advertisementId: {}", orderDTO.getBuyerUserId(), orderDTO.getAdvertisementId());
        // check that buyer exists in db
        User buyer = userRepository.findById(orderDTO.getBuyerUserId())
                .orElseThrow(() -> new EntityNotFoundException("Buyer with provided user ID does not exist"));
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buyer with provided user ID does not exist"));

        // check that the ad exists in db
        Advertisement advertisement = advertisementRepository.findById(orderDTO.getAdvertisementId())
                .orElseThrow(() -> new EntityNotFoundException("Advertisement with provided ID does not exist"));
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement with provided ID does not exist"));

        User seller = advertisement.getUserId();
        if (seller == null) {
            throw new EntityNotFoundException("Seller not found for advertisement");
        }
        // Verify that the seller exists in the database
        userRepository.findById(seller.getId())
                .orElseThrow(() -> new EntityNotFoundException("Seller with provided user ID does not exist"));

        //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller with provided user ID does not exist"));


        Order order = new Order();
        order.setBuyerUserId(buyer);
        order.setAdvertisementId(advertisement);
        order.setSellerUserId(advertisement.getUserId());
        logger.info("Order created successfully with ID: {}", order.getId());
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
       orderDTO.setBuyerUserId(order.getBuyerUserId() != null ? order.getBuyerUserId().getId(): null);
       orderDTO.setAdvertisementId(order.getAdvertisementId()!= null ? order.getAdvertisementId().getId(): null);
       orderDTO.setSellerUserId(order.getSellerUserId()!= null ? order.getSellerUserId().getId(): null);
       orderDTO.setOrderDate(order.getOrderDate());
       orderDTO.setQuantity(order.getQuantity());
       orderDTO.setTotalPrice(order.getTotalPrice());
       orderDTO.setSold(order.isSold());
       orderDTO.setCreatedAt(order.getCreatedAt());
       orderDTO.setUpdatedAt(order.getUpdatedAt());
       return orderDTO ;
    }

    public Order updateOrder(String id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    //Have to consider what you can update in Order, for example don't think IDs should be updated.
                    existingOrder.setQuantity(updatedOrder.getQuantity());
                    existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
                    existingOrder.setSold(updatedOrder.isSold());
                    // Automatically update the updatedAt timestamp to the current date/time
                    existingOrder.setUpdatedAt(new Date());
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }


        // Method to delete an Order by its ID
        public void deleteOrder (String id){
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with ID " + id + " not found."));
            orderRepository.deleteById(id);


        }
    }
