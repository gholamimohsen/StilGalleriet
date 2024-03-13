package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.OrderDTO;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.Order;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.payload.response.OrderResponse;
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
        // since the ad already has a user that is by default the seller of the ad
        // and since I implemented check mon user i ad service no need to check again
        // we can be sure the user exists
        // and we set the seller from the user in the ad
        order.setSellerUserId(advertisement.getUser());

        return orderRepository.save(order);
    }

    /*
    * public Order createOrder(OrderDTO orderDTO) {

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        // lista med produkter, då måste mappa/loopa igenom listan och hitta idn
        List<Product> products = new ArrayList<>();
        for (String productId : orderDTO.getProductIds()) {
            products.add(productRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product id")));
        }

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setProducts(products);
        newOrder.setOrderedDate(orderDTO.getOrderedDate());

        return  orderRepository.save(newOrder);
    }
    * */

    // Method to add a new Order
    /*public Order createOrder(OrderDTO orderDTO) {
        Optional<User> seller = Optional.of(userRepository.findById(orderDTO.getSellerUserId())).orElseThrow(()->new RuntimeException("Invalid  seller user id"));
        Optional<User> buyer = Optional.of(userRepository.findById(orderDTO.getBuyerUserId())).orElseThrow(()->new RuntimeException("Invalid  buyer user id"));


        List<Advertisement> advertisements = new ArrayList<>();
        for (String AdvertisementId : orderDTO.getAdvertisementId()) {
            advertisements.add(advertisementRepository.findById(AdvertisementId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid advertisement id")));
        }

        Order order= new Order();
        order.setSellerUserId(seller.get());
        order.setBuyerUserId(buyer.get());
        order.setAdvertisementId(advertisements);
       // order.setQuantity(orderDTO.getQuantity());
        //order.setTotalPrice(orderDTO.getTotalPrice());
        return orderRepository.save(order);

    }*/


    // Method to retrieve all  Orders
    public List<OrderResponse> getAllOrders() {
        List<Order> orders= orderRepository.findAll();
        return  orders.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    // Method to find an Order by its ID
    public List<OrderResponse> getOrderById(String id){
        Optional<Order> orders =orderRepository.findById(id);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private OrderResponse convertToDTO(Order order) {
        return convertToDTO(order);
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
