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
        AdvertisementBuilder advertisementBuilder = new AdvertisementBuilder.Builder(user, "Test")
                .description("testing").build();
        return advertisementBuilderRepository.save(advertisementBuilder);
    }
}
