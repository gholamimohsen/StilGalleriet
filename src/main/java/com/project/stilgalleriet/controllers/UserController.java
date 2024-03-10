
package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stilgalleriet/users")

public class UserController {
    @Autowired
    UserService userService;


    //POST
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
        }

        //GET
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //GET by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    //PUT
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {

        return userService.updateUser(id, user);

    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
