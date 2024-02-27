package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdvertisementService {
    @Autowired

    AdvertisementRepository advertisementRepository;

    //create an advertisement

    public Advertisement createAdvertisement(Advertisement advertisement){
        return advertisementRepository.save(advertisement);

    }


    //get all advertisements

    public List<Advertisement> getAllAdvertisements(){
        return advertisementRepository.findAll();
    }


    // get an advertisement by id

    public Optional<Advertisement> getAdvertisementById(String id){
        return advertisementRepository.findById(id);
    }


    //delete an advertisement by id

    public void deleteAdvertisement(String id){
        advertisementRepository.deleteById(id);
    }

    ///update an advertisement

    public Advertisement updatedAdvertisement (String id, Advertisement updatedAdvertisement){
        return advertisementRepository.save(updatedAdvertisement);
    }



}
