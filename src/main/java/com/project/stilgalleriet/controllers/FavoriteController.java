package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.dto.FavoritesDTO;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.Favorites;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.UserRepository;
import com.project.stilgalleriet.services.AdvertisementService;
import com.project.stilgalleriet.services.FavoriteService;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private UserRepository userRepository;



    @PostMapping
    public ResponseEntity<?> addFavorite(@RequestBody FavoritesDTO favoriteDTO) {
        try {
            User user = userService.findById(favoriteDTO.getUserId());
            Advertisement advertisement = advertisementService.findById(favoriteDTO.getAdvertisementId());

            Favorites favorite = new Favorites();
            favorite.setUserIdFav(user);
            favorite.setAdvertisementId(advertisement);

            // Lägg till den nya favoriten till användarens lista av favoriter
            List<Advertisement> favorites = user.getFavorites();
            favorites.add(favorite.getAdvertisementId());
            user.setFavorites(favorites);

            // Spara hela User-objektet, inklusive den uppdaterade listan av favoriter
            User updatedUser = userRepository.save(user);

            return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Logga felet här
            return new ResponseEntity<>("Det gick inte att lägga till favoriten", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /*
    @PostMapping
    public ResponseEntity<?> addFavorite(@RequestBody FavoritesDTO favoriteDTO) {
        try {
            User user = userService.findById(favoriteDTO.getUserId());
            Advertisement advertisement = advertisementService.findById(favoriteDTO.getAdvertisementId());

            Favorites favorite = new Favorites();
            favorite.setUserIdFav(user);
            favorite.setAdvertisementId(advertisement);

            Favorites savedFavorite = favoriteService.addFavorite(favorite);
            return new ResponseEntity<>(savedFavorite, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Det gick inte att lägga till favoriten", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    /*
    @PostMapping
    public Favorites addFavorite(@RequestBody FavoritesDTO favoriteDTO) {
        User user = userService.findById(favoriteDTO.getUserId());
        Advertisement advertisement = advertisementService.findById(favoriteDTO.getAdvertisementId());

        Favorites favorite = new Favorites();
        favorite.setUserIdFav(user);
        favorite.setAdvertisementId(advertisement);

        return favoriteService.addFavorite(favorite);
    }
*/
    @DeleteMapping("/{id}")
    public void removeFavorite(@PathVariable String id) {
        favoriteService.removeFavorite(id);
    }

    @GetMapping("/{userId}")
    public List<Favorites> getFavoritesByUser(@PathVariable String userId) {
        User user = userService.findById(userId);
        return favoriteService.getFavoritesByUser(user);
    }
}
