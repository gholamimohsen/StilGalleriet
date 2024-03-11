package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.*;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    //create an advertisement
    public Advertisement addAdvertisement(Advertisement advertisement){
        return advertisementRepository.save(advertisement);
    }


    //get all advertisements
    public List<Advertisement> getAllAdvertisements(){
        return advertisementRepository.findAll();

    }

    //get an advertisement by id
    public Optional<Advertisement> getAdvertisementById(String id){
        return advertisementRepository.findById(id);
    }

    //delete an advertisement

    public void deleteAdvertisement(String id){
        advertisementRepository.deleteById(id);
    }

    //update an advertisement
    public Advertisement updateAdvertisement(String id, Advertisement updatedAdvertisement) throws Exception {
        return advertisementRepository.findById(id)
                .map(existingAdvertisement->{
                    if (updatedAdvertisement.getTitle() !=null){
                        existingAdvertisement.setTitle(updatedAdvertisement.getTitle());
                    }

                    if (updatedAdvertisement.getDescription()!=null){
                        existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
                    }
                     if (updatedAdvertisement.getCategory()!=null){
                         existingAdvertisement.setCategory(updatedAdvertisement.getCategory());
                     }

                    if (updatedAdvertisement.getColor()!=null){
                        existingAdvertisement.setColor(updatedAdvertisement.getColor());
                    }
                    if (updatedAdvertisement.getGender()!=null){
                        existingAdvertisement.setGender(updatedAdvertisement.getGender());
                    }
                    if (updatedAdvertisement.getImgUrl()!=null){
                        existingAdvertisement.setImgUrl(updatedAdvertisement.getImgUrl());
                    }
                    if (updatedAdvertisement.getPrice()!=0.00){
                        existingAdvertisement.setPrice(updatedAdvertisement.getPrice());

                    }
                   if (updatedAdvertisement.isActive()==false ){
                        existingAdvertisement.setIsActive(false);
                    }
                    return advertisementRepository.save(existingAdvertisement);

                })
                .orElseThrow(()-> new Exception("Advertisement with id: "+ id + " was not found to update!"));
    }

    //Get advertisement list by color
    public List <Advertisement> findAdvertisementByColor(String color){
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

    //Get advertisement list by date that is created after
    public List<Advertisement> findAdvertisementByCreatedAtAfter(Date date){
        return advertisementRepository.findAdvertisementByCreatedAtAfter(date);
    }



}

