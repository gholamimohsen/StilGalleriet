package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;

public class AdFilterByMaxPrice implements AdvertisementFilterStrategy{
    private double maxPrice;

    public AdFilterByMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }


    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementService advertisementService) {
        return advertisementService.findAdvertisementByPriceLessThan(maxPrice);
    }
}
