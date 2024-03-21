package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Favorites;
import com.project.stilgalleriet.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoriteRepository extends MongoRepository <Favorites, String> {
    List<Favorites> findByUserIdFav(User user);
}
