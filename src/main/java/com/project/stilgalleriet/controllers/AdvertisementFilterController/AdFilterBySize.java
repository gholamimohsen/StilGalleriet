package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;

public class AdFilterBySize implements AdvertisementFilterStrategy{
    private final String size;

    public AdFilterBySize(String size){
        this.size=size;
    }

    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementService advertisementService) {
        return advertisementService.findAdvertisementBySize(size);
    }
}
