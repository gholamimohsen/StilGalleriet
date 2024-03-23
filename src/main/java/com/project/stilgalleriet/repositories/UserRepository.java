package com.project.stilgalleriet.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.project.stilgalleriet.models.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);



}


