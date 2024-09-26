package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;

public class AdFilterByGender implements AdvertisementFilterStrategy{
    private final String gender;

    public AdFilterByGender(String gender){
        this.gender=gender;
    }

    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementService advertisementService) {
        return advertisementService.findAdvertisementByGender(gender);
    }
}
