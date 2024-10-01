package com.project.stilgalleriet.services;

import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFavoritesService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;

    // FAVORITES ADVERTISEMENT METHODS

    //Post Favorites
    /*public void addFavorite (String usernameId, String advertisementId ) {
        Optional<User> userOptional = userRepository.findByUsername(usernameId);
        Optional<Advertisement> advertisementOptional = advertisementRepository.findAdvertisementById(advertisementId);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        if (advertisementOptional.isEmpty()) {
            throw  new EntityNotFoundException("Advertisement not found");
        }

        User user = userOptional.get();
        Advertisement advertisement = advertisementOptional.get();
        if (user.getFavorites().contains(advertisement)) { //Checks if you already have this advertisement in favorites.
            throw new IllegalArgumentException("Advertisement is already in favorites.");
        }
        user.getFavorites().add(advertisement);
        userRepository.save(user);
    }

    //GET all Advertisement Favorites

    public List<Advertisement> getAddFavorites(String usernameId) {
        Optional<User> userOptional = userRepository.findByUsername(usernameId);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = userOptional.get();
        return new ArrayList<>(user.getFavorites());
    }

    //DELETE an Advertisement Favorite

    public void removeAddFavorite(String usernameId, String advertisementId) {
        Optional<User> userOptional = userRepository.findByUsername(usernameId);
        Optional<Advertisement> advertisementOptional = advertisementRepository.findAdvertisementById(advertisementId);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        if (advertisementOptional.isEmpty()) {
            throw new EntityNotFoundException("Advertisement not found");
        }
        User user = userOptional.get();
        Advertisement advertisement = advertisementOptional.get();

        if(!user.getFavorites().contains(advertisement)) { //Checks if Advertisement is not in your favorite with (!)
            throw new IllegalArgumentException("Advertisement is not in favorites");
        }

        user.getFavorites().remove(advertisement);
        userRepository.save(user);


    }*/



}
