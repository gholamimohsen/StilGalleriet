
package com.project.stilgalleriet.services;

import com.project.stilgalleriet.Mappers.UserMapper;
import com.project.stilgalleriet.dto.UserDTO;
import com.project.stilgalleriet.exception.EntityNotFoundException;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository =userRepository;

    }
    // Method to create a new user from a UserDTO (Data Transfer Object)
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO); // Business Logic (Mapping), Convert DTO to entity using the UserMapper
        User savedUser= userRepository.save(user); // Data Access (Interacting with Repository)
        return UserMapper.toDto(savedUser); // Converts the saved User entity back to a DTO to return it as a response.
    }

    // Method to get all users, restricted to admin users only.
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> getAllUsers() {
        List<User>users =userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDto) // Maps each User entity to a UserDTO using the mapper.
                .collect(Collectors.toList()); // Data access logic directly in service, // Collects all the DTOs into a list and returns it.
    }

    public UserDTO getUserById(String id) {
        User user = findUserById(id); // Uses a helper method to find the user by ID
        return UserMapper.toDto(user); // Converts the found User entity to a DTO and returns it.
    }


    // Private helper method to find a user by their ID.
    // Throws an EntityNotFoundException if the user is not found in the database.
    private User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found with id: " + id));
    }

    // Private helper method to save a user entity.
    // Isolates the repository logic for saving users to make the service methods more modular and reusable.
        private User saveUser(User user) {
            return userRepository.save(user); // Saves the user entity to the database.
        }

    // Method to update an existing user using their ID and new data from a UserDTO.
    public UserDTO updateUser(String id, UserDTO userDTO) {
        User existingUser = findUserById(id); // Retrieves the existing user from the database.

        // Updates the user's attributes with the values from the DTO.
            existingUser .setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setStreet(userDTO.getStreet());
            existingUser.setCity(userDTO.getCity());
            existingUser.setState(userDTO.getState());
            existingUser.setZipcode(userDTO.getZipcode());
            existingUser.setActive(userDTO.isActive());

        User updatedUser = saveUser(existingUser); // Saves the updated user to the database.
        return UserMapper.toDto(updatedUser);// Converts the updated user entity to a DTO and returns it
        }

        // Delete user
        public String deleteUser(String id) {
            User user = findUserById(id); // Retrieves the user by ID using the helper method.
            userRepository.delete(user); // Deletes the user entity from the database.
            return "User deleted successfully";
        }

}





