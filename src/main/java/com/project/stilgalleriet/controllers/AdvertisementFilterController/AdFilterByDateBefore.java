package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementFilterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdFilterByDateBefore implements AdvertisementFilterStrategy{

    private String dateString;

    public AdFilterByDateBefore(String dateString) {
        this.dateString = dateString;
    }


    @Override
    public List<Advertisement> filterAdvertisements(AdvertisementFilterService advertisementFilterService) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(dateString);
            Date endDate = new Date();
            return advertisementFilterService.findAdvertisementByCreatedAtBefore(startDate, endDate);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format", e);
        }

    }
}
