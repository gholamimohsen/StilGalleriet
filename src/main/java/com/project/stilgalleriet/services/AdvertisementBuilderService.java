package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.AdvertisementDTO;
import com.project.stilgalleriet.models.AdvertisementBuilder;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.AdvertisementBuilderRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementBuilderService {

    @Autowired
    AdvertisementBuilderRepository advertisementBuilderRepository;

    @Autowired
    UserRepository userRepository;
    public AdvertisementBuilder createAdvertisementBuilder(AdvertisementDTO advertisementDTO){
        User user = userRepository.findById(advertisementDTO.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
        AdvertisementBuilder advertisementBuilder = new AdvertisementBuilder.Builder()
                .userId(user)
                .title("dark art test")
                .description(advertisementDTO.getAdDescriptions()) //Not working, might even make my own DTO for this or remove DTO
                .build();
        return advertisementBuilderRepository.save(advertisementBuilder);
    }
}
