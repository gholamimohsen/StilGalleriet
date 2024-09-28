package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementFilterService;

import java.util.List;

public class AdFilterByCategory implements AdvertisementFilterStrategy{
    private final String category;

    public AdFilterByCategory(String category){
        this.category=category;
    }

    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementFilterService advertisementFilterService) {
        return advertisementFilterService.findAdvertisementByCategory(category);
    }
}
