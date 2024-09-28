package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementFilterService;

import java.util.List;

public class AdFilterByPriceBetween implements AdvertisementFilterStrategy{
     private double minPrice;
     private double maxPrice;

    public AdFilterByPriceBetween(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice=maxPrice;
    }

    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementFilterService advertisementFilterService) {
        return advertisementFilterService.findAdvertisementByPriceBetween(minPrice,maxPrice);
    }
}
