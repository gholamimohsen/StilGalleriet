
package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }




}






    //POST
    // ta bort ni har register
   /* @PostMapping()
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


    // FAVORITES ADVERTISEMENT METHODS

    //POST ADD a favorite
    @PostMapping("/{username}/favorites/{advertisementId}")
    public  ResponseEntity<?> addFavorite(@PathVariable String username, @PathVariable String advertisementId) {
        userService.addFavorite(username, advertisementId);
        return ResponseEntity.ok("Advertisement has been added to your favorites");
    }

    //GET all Advertisement Favorites

    @GetMapping("/{username}/favorites/all")
    public ResponseEntity<?> getAddFavorites(@PathVariable String username) {
        List<Advertisement> favorites = userService.getAddFavorites(username);
        return ResponseEntity.ok(favorites);
    }

    //DELETE an Advertisement Favorite

    @DeleteMapping("/{username}/favorites/{advertisementId}")
    public ResponseEntity<?> removeAddFavorite(@PathVariable String username, @PathVariable String advertisementId ) {
        userService.removeAddFavorite(username, advertisementId);
        return ResponseEntity.ok("Advertisement has been removed from you favorites");
    }
*/


