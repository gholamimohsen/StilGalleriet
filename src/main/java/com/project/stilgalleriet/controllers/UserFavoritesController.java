package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.services.AdvertisementService;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users/favorites")

public class UserFavoritesController {
    @Autowired
    UserService userService;

    @Autowired
    AdvertisementService advertisementService;

    // FAVORITES ADVERTISEMENT METHODS

    //POST ADD a favorite
   /* @PostMapping("/{username}/favorites/{advertisementId}")
    public ResponseEntity<?> addFavorite(@PathVariable String username, @PathVariable String advertisementId) {
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
    }*/


}
