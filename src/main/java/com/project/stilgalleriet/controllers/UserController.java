
package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.dto.UserDTO;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;
    @Autowired
 public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping
        public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Calls the service to create the user and returns the newly created UserDTO
        UserDTO newUser = userService.createUser(userDTO);
        // Returns the new user with a 200 OK response
        return ResponseEntity.ok(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        // Calls the service to fetch the user by ID
        UserDTO  user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Calls the service to fetch all users
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        // Calls the service to update the user and returns the updated UserDTO
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        // Calls the service to delete the user and returns a success message
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }




}








