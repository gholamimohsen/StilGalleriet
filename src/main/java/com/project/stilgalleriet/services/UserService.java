package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    //create / Post user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //read / Get user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get user by specific id
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    //update / Put user
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //Delete user
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User successfully deleted";
    }

}
