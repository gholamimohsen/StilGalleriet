package com.project.stilgalleriet.services;

import com.project.stilgalleriet.Mappers.OrderMapper;
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
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    // // Inject dependencies for repository access to handle CRUD operations on Orders, Users, and Advertisements
    @Autowired
     OrderRepository orderRepository;


    @Autowired
    UserRepository userRepository;
    @Autowired
    AdvertisementRepository advertisementRepository;

    // Logger instance for logging important information and debug messages
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * Create a new order using OrderDTO.
     * The method validates that the buyer, seller, and advertisement exist in the system before creating the order.
     *
     * @param orderDTO - Data Transfer Object containing order details like buyer and advertisement IDs
     * @return The saved Order entity
     */

    public Order createOrder(OrderDTO orderDTO) {
        // Log the creation process with buyerId and advertisementId
        logger.debug("Creating order for buyerId: {} and advertisementId: {}", orderDTO.getBuyerUserId(), orderDTO.getAdvertisementId());
        // Validate and retrieve the buyer from the userRepository, or throw an exception if not found
        User buyer = userRepository.findById(orderDTO.getBuyerUserId())
                .orElseThrow(() -> new EntityNotFoundException("Buyer with provided user ID does not exist"));


        // check that the ad exists in db
        Advertisement advertisement = advertisementRepository.findById(orderDTO.getAdvertisementId())
                .orElseThrow(() -> new EntityNotFoundException("Advertisement with provided ID does not exist"));

        // Get the seller associated with the advertisement
        User seller = advertisement.getUserId();
        if (seller == null) {
            throw new EntityNotFoundException("Seller not found for advertisement");
        }
        // Verify that the seller exists in the database
        userRepository.findById(seller.getId())
                .orElseThrow(() -> new EntityNotFoundException("Seller with provided user ID does not exist"));



        // Create and populate the new Order entity with the provided data
        Order order = new Order();
        order.setBuyerUserId(buyer);
        order.setAdvertisementId(advertisement);
        order.setSellerUserId(advertisement.getUserId());
        order.setIsSold(true);
        // Log that the order was created successfully
        logger.info("Order created successfully with ID: {}", order.getId());
        // Save and return the created order entity
        return orderRepository.save(order);
    }

    /**
     * Retrieve all orders from the database.
     * This method converts each Order entity to OrderResponse DTOs.
     *
     * @return List of OrderResponse DTOs representing all orders
     */
    public List<OrderResponse> getAllOrders() {
        // Fetch all orders from the database
        List<Order> orders= orderRepository.findAll();

        // Convert the list of Order entities to OrderResponse DTOs using OrderMapper
        return  orders.stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());

    }
    /**
     * Find a specific order by its ID.
     * Converts the found Order entity to an OrderResponse DTO.
     *
     * @param id - The ID of the order to find
     * @return OrderResponse DTO representing the found order
     */
    public OrderResponse getOrderById(String id) {
        // Retrieve the order by ID, or throw an exception if not found
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " not found."));
        // Convert the Order entity to OrderResponse DTO using OrderMapper
        return OrderMapper.toDto(order);
    }

    /**
     * Update an existing order by its ID.
     * This method allows updating certain fields of the order like quantity and total price.
     *
     * @param id - The ID of the order to update
     * @param updatedOrder - The Order entity containing updated fields
     * @return The updated Order entity
     */


    public Order updateOrder(String id, Order updatedOrder) {
        // Find the existing order by ID and update its fields, or throw an exception if not found
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    //Have to consider what you can update in Order, for example don't think IDs should be updated.
                    existingOrder.setQuantity(updatedOrder.getQuantity());
                    existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
                    existingOrder.setSold(updatedOrder.isSold());
                    // Automatically update the updatedAt timestamp to the current date/time
                    existingOrder.setUpdatedAt(new Date());
                    // Save and return the updated order
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }


    /**
     * Delete an order by its ID.
     *
     * @param id - The ID of the order to delete
     */
        public void deleteOrder (String id){
            // Find the order by ID, or throw an exception if not found
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " not found."));
            orderRepository.deleteById(id);


        }
    }
