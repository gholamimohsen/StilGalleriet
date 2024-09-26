package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;

public class AdFilterByMinPrice implements AdvertisementFilterStrategy{
    private double minPrice;
    public AdFilterByMinPrice(double minPrice){
        this.minPrice=minPrice;
    }


    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementService advertisementService) {
        return advertisementService.findAdvertisementByPriceGreaterThan(minPrice);
    }
}
