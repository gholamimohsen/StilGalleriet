
package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;




    //create / Post user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //read / Get user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get user by specific id
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    //Update user. Replaced with an update method. The previous "update" method was a create operation.
    public User updateUser(String id, User updatedUser){

        //No exception handling added!
        return userRepository.findById(id)
                .map(user -> {

                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    user.setStreet(updatedUser.getStreet());
                    user.setCity(updatedUser.getCity());
                    user.setState(updatedUser.getState());
                    user.setZipcode(updatedUser.getZipcode());
                    user.setActive(updatedUser.isActive());
                    List<Advertisement> favorites = user.getFavorites();
                    favorites.addAll(updatedUser.getFavorites());
                    user.setFavorites(favorites);
                   // user.setFavorites(updatedUser.getFavorites()); //This might overwrite favorites, probably need .add method from ArrayList

                    return userRepository.save(user);

                })
                .orElseThrow();
    }

    //Delete user
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User successfully deleted";
    }


    //Favorites
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

}
