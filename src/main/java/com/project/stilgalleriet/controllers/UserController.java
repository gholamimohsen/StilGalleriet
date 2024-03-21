
package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    UserService userService;


    //POST
    // ta bort ni har register
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
        }

        // en user ska väl inte kunna hämta alla users?
        // bör endast vara admins som kan göra det
        //GET
        @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //GET by id
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    //PUT
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {

        return userService.updateUser(id, user);

    }

    //DELETE
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }


    // FAVORITES

    //POST
    @PostMapping("/{username}/favorites")
    public  ResponseEntity<?> addFavorite(@PathVariable String username, @RequestBody Map<String, String> body) {
        String adId = body.get("adId");
        userService.addFavorites(username,adId);

        return ResponseEntity.ok("Advertisement has been added to your favorites");
    }

}
