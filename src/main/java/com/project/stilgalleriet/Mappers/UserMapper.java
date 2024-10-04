package com.project.stilgalleriet.Mappers;

import com.project.stilgalleriet.dto.UserDTO;
import com.project.stilgalleriet.models.User;

public class UserMapper {

    // Convert User entity to UserDTO
    //Converts a User entity into a UserDTO to ensure that only the necessary data is transferred between the server and client.
    public static UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        // Set the username from the User entity to the DTO
        dto.setUsername(user.getUsername());
        // Set the first and last name from the User entity
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        // Set the email from the User entity to the DTO
        dto.setEmail(user.getEmail());
        dto.setStreet(user.getStreet());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setZipcode(user.getZipcode());
        // Set the active status (is the user active or not)
        dto.setActive(user.isActive());
        dto.setFavorites(user.getFavorites() != null ?
                user.getFavorites().stream().map(ad -> ad.getId()).toList() : null);
        return dto; // Return the populated UserDTO
    }

    // Convert UserDTO to User entity
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setStreet(dto.getStreet());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setZipcode(dto.getZipcode());
        user.setActive(dto.isActive());
        // No need to handle favorites in DTO -> entity conversion
        return user;
    }

}
