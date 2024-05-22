package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    Order findOrderByBuyerUserIdAndSellerUserId(String buyer, String seller);

    List<Order> findOrderByBuyerUserId_Id(String buyer);

}
