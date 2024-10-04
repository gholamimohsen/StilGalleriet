package com.project.stilgalleriet.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteService {
    private final UserService userService;
    private final AdvertisementService advertisementService;

    public FavoriteService(UserService userService, AdvertisementService advertisementService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
    }

    public void addFavorite(String username, String adsId) {
        userService.addFavorite(username, adsId);

    }

    public List getAllFavorites(String username) {
        return userService.getAddFavorites(username);
    }

    public void removeFavorite(String username, String adsId) {
        userService.removeAddFavorite(username, adsId);
    }
}
