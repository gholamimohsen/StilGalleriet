
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
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO); // Business Logic (Mapping), Convert DTO to entity
        User savedUser= userRepository.save(user); // Data Access (Interacting with Repository)
        return UserMapper.toDto(savedUser); // Business Logic (Mapping)
    }

    // Get all users
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> getAllUsers() {
        List<User>users =userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList()); // Data access logic directly in service
    }

    public UserDTO getUserById(String id) {
        User user = findUserById(id); // Separat metod för att hitta användaren
        return UserMapper.toDto(user); // Använder en mapper för att konvertera till DTO
    }

    // Hjälpmetod för att hitta användaren
    private User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found with id: " + id));
    }


        private User saveUser(User user) {
            return userRepository.save(user);
        }


    public UserDTO updateUser(String id, UserDTO userDTO) {
        User existingUser = findUserById(id);

            existingUser .setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setStreet(userDTO.getStreet());
            existingUser.setCity(userDTO.getCity());
            existingUser.setState(userDTO.getState());
            existingUser.setZipcode(userDTO.getZipcode());
            existingUser.setActive(userDTO.isActive());
        User updatedUser = saveUser(existingUser);
        return UserMapper.toDto(updatedUser);
        }

        // Delete user
        public String deleteUser(String id) {
            User user = findUserById(id);
            userRepository.delete(user);
            return "User deleted successfully";
        }

}





