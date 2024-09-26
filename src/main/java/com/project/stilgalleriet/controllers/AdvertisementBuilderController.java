package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.dto.AdvertisementDTO;
import com.project.stilgalleriet.models.AdvertisementBuilder;
import com.project.stilgalleriet.services.AdvertisementBuilderService;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/builder")
public class AdvertisementBuilderController {

    @Autowired
    private AdvertisementBuilderService advertisementBuilderService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<AdvertisementBuilder> createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
        AdvertisementBuilder advertisementBuilder = advertisementBuilderService.createAdvertisementBuilder(advertisementDTO);
        return ResponseEntity.ok(advertisementBuilder);
    }


}
