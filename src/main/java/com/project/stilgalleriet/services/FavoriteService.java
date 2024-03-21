package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Favorites;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorites addFavorite(Favorites favorite) {
        return favoriteRepository.save(favorite);
    }
    public List<Favorites> getFavoritesByUser(User user) {
        return favoriteRepository.findByUserIdFav(user);
    }

    public void removeFavorite(String id) {
        favoriteRepository.deleteById(id);
    }
}
