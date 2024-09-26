package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;


public class AdFilterByColor implements AdvertisementFilterStrategy {

    private final String color;

    public AdFilterByColor(String color){
        this.color=color;
    }

    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementService advertisementService) {
        return advertisementService.findAdvertisementByColor(color);
    }

}
