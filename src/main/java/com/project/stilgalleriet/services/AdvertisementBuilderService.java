package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.AdvertisementRequest;
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
    public AdvertisementBuilder createAdvertisementBuilder(AdvertisementRequest advertisementRequest){
        User user = userRepository.findById(advertisementRequest.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        AdvertisementBuilder advertisementBuilder = AdvertisementBuilder.builder()
                //Mandatory fields - Must have in order to compile
                .userId(user)
                .title(advertisementRequest.getTitle())
                .price(advertisementRequest.getPrice())
                //Optional fields
                .description(advertisementRequest.getDescription())
                .images(advertisementRequest.getImages())
                .category(advertisementRequest.getCategory())
                .color(advertisementRequest.getColor())
                .gender(advertisementRequest.getGender())
                .size(advertisementRequest.getSize())
                .build();
        return advertisementBuilderRepository.save(advertisementBuilder);
    }
}
