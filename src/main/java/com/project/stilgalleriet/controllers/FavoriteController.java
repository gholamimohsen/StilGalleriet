package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.services.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FavoriteController {
    private final FavoriteService favoriteService;


    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;

    }

    @PostMapping("/{username}/favorites/{advertisementId}")
    public ResponseEntity<?> addFavorite(@PathVariable String username, @PathVariable String advertisementId) {
        favoriteService.addFavorite(username, advertisementId);
        return ResponseEntity.ok("Advertisement has been added to your favorites");
    }

    //GET all Advertisement Favorites

    @GetMapping("/{username}/favorites/all")
    public ResponseEntity<?> getAddFavorites(@PathVariable String username) {
        List favorites = favoriteService.getAllFavorites(username);
        return ResponseEntity.ok(favorites);
    }

    //DELETE an Advertisement Favorite

    @DeleteMapping("/{username}/favorites/{advertisementId}")
    public ResponseEntity<?> removeFavorite(@PathVariable String username, @PathVariable String advertisementId ) {
        favoriteService.removeFavorite(username, advertisementId);
        return ResponseEntity.ok("Advertisement has been removed from your favorites");
    }
}
