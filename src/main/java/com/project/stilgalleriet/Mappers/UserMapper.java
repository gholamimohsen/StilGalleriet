package com.project.stilgalleriet.Mappers;

import com.project.stilgalleriet.dto.UserDTO;
import com.project.stilgalleriet.models.User;

public class UserMapper {

    // Convert User entity to UserDTO
    public static UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setStreet(user.getStreet());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setZipcode(user.getZipcode());
        dto.setActive(user.isActive());
        dto.setFavorites(user.getFavorites() != null ?
                user.getFavorites().stream().map(ad -> ad.getId()).toList() : null);
        return dto;
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
