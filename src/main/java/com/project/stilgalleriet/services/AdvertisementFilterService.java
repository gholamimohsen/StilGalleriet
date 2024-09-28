package com.project.stilgalleriet.services;


import com.project.stilgalleriet.dto.AdvertisementDTO;
import com.project.stilgalleriet.models.*;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdvertisementFilterService {
    @Autowired
    AdvertisementRepository advertisementRepository;

    private AdvertisementDTO convertToDTO(Advertisement advertisement) {
        AdvertisementDTO advertisementDTO = new AdvertisementDTO();
        advertisementDTO.setAdId(advertisement.getId());
        advertisementDTO.setSellerId(advertisement.getUserId().getId());
        advertisementDTO.setAdTitles(advertisement.getTitle());
        advertisementDTO.setAdDescriptions(advertisement.getDescription());
        advertisementDTO.setAdCategory(advertisement.getCategory());
        advertisementDTO.setAdColor(advertisement.getColor());
        advertisementDTO.setAdGender(advertisement.getGender());
        advertisementDTO.setAdPrice(advertisement.getPrice());
        advertisementDTO.setAdSize(advertisement.getSize());
        advertisementDTO.setAdImgUrls(advertisement.getImgUrl());
        advertisementDTO.setAdIsActive(true);
        return advertisementDTO;

    }

    //Get advertisement list by color
    public List<Advertisement> findAdvertisementByColor(String color){
        return advertisementRepository.findAdvertisementByColor(EColor.fromString(color.toUpperCase()));
    }

    // Get advertisement list by gender
    public List <Advertisement> findAdvertisementByGender(String gender){
        return advertisementRepository.findAdvertisementByGender(EGender.fromString(gender.toUpperCase()));
    }

    //Get advertisement list by size
    public List<Advertisement> findAdvertisementBySize(String size){
        return advertisementRepository.findAdvertisementBySize(ESize.fromString(size.toUpperCase()));
    }

    //Get advertisement list by category
    public List<Advertisement> findAdvertisementByCategory(String category){
        return advertisementRepository.findAdvertisementByCategory(ECategory.fromString(category.toUpperCase()));
    }

    //Get advertisement list only with actives
    public List<Advertisement> findAdvertisementByActive(boolean isActive){
        return advertisementRepository.findAdvertisementByActive(true);
    }


    // Get advertisement list by price less than maxPrice
    public List<Advertisement> findAdvertisementByPriceLessThan(double maxPrice){
        return advertisementRepository.findAdvertisementByPriceLessThan(maxPrice);
    }

    // Get advertisement list by price greater than minPrice
    public List<Advertisement> findAdvertisementByPriceGreaterThan(double minPrice){
        return advertisementRepository.findAdvertisementByPriceGreaterThan(minPrice);
    }

    // Get advertisement list by price between min and max
    public List<Advertisement> findAdvertisementByPriceBetween(double minPrice, double maxPrice){
        return advertisementRepository.findAdvertisementByPriceBetween(minPrice, maxPrice);
    }

    //Get advertisement list by date that is created at after the date
    public List<Advertisement> findAdvertisementByCreatedAtAfter(Date startedDate, Date endDate){
        return advertisementRepository.findAdvertisementByCreatedAtAfter(startedDate, endDate);
    }

    //Get advertisement list by date that is created at before the date
    public List<Advertisement> findAdvertisementByCreatedAtBefore(Date startedDate, Date endDate){
        return advertisementRepository.findAdvertisementByCreatedAtBefore(startedDate,endDate);
    }

}
