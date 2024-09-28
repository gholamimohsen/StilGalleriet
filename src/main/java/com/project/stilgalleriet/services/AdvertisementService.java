package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.AdvertisementRequest;
import com.project.stilgalleriet.models.*;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    UserRepository userRepository;

    //create an advertisement
    public Advertisement createAdvertisement(AdvertisementRequest advertisementRequest) {
        User user = userRepository.findById(advertisementRequest.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        Advertisement newAd = new Advertisement();
        newAd.setUserId(user);
        newAd.setTitle(advertisementRequest.getTitle());
        //newAd.setActive(advertisementDTO.isAdvIsActive());
        newAd.setCategory(advertisementRequest.getAdCategory());
        newAd.setColor(advertisementRequest.getAdColor());
        newAd.setDescription(advertisementRequest.getDescription());
        newAd.setGender(advertisementRequest.getGender());
        newAd.setSize(advertisementRequest.getAdSize());
        newAd.setPrice(advertisementRequest.getAdPrice());
        newAd.setCreatedAt(advertisementRequest.getAdDate());
        newAd.setImgUrl(advertisementRequest.getAdImgUrls());
        newAd.setUpdatedAt(advertisementRequest.getAdUpdatedDate());

        return advertisementRepository.save(newAd);
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
    public Advertisement updateAdvertisement(String id, AdvertisementRequest updatedAdvertisement) throws Exception {
        return advertisementRepository.findById(id)
                .map(existingAdvertisement -> {
                    if (updatedAdvertisement.getTitle() != null) {
                        existingAdvertisement.setTitle(updatedAdvertisement.getTitle());
                    }
                    if (updatedAdvertisement.getDescription() != null) {
                        existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
                    }
                    if (updatedAdvertisement.getAdCategory() != null) {
                        existingAdvertisement.setCategory(updatedAdvertisement.getAdCategory());
                    }

                    if (updatedAdvertisement.getAdColor() != null) {
                        existingAdvertisement.setColor(updatedAdvertisement.getAdColor());
                    }
                    if (updatedAdvertisement.getGender() != null) {
                        existingAdvertisement.setGender(updatedAdvertisement.getGender());
                    }
                    if (updatedAdvertisement.getAdImgUrls() != null) {
                        existingAdvertisement.setImgUrl(updatedAdvertisement.getAdImgUrls());
                    }
                    if (updatedAdvertisement.getAdPrice() != 0.00) {
                        existingAdvertisement.setPrice(updatedAdvertisement.getAdPrice());

                    }
                    if (updatedAdvertisement.isAdIsActive() != existingAdvertisement.isActive()) {
                        existingAdvertisement.setActive(updatedAdvertisement.isAdIsActive());
                    }
                    return advertisementRepository.save(existingAdvertisement);

                })
                .orElseThrow(()-> new IllegalArgumentException("Advertisement with id: "+ id + " was not found to update!"));
    }

    private AdvertisementRequest convertToDTO(Advertisement advertisement) {
        AdvertisementRequest advertisementRequest = new AdvertisementRequest();
        advertisementRequest.setAdId(advertisement.getId());
        advertisementRequest.setSellerId(advertisement.getUserId().getId());
        advertisementRequest.setTitle(advertisement.getTitle());
        advertisementRequest.setDescription(advertisement.getDescription());
        advertisementRequest.setAdCategory(advertisement.getCategory());
        advertisementRequest.setAdColor(advertisement.getColor());
        advertisementRequest.setGender(advertisement.getGender());
        advertisementRequest.setAdPrice(advertisement.getPrice());
        advertisementRequest.setAdSize(advertisement.getSize());
        advertisementRequest.setAdImgUrls(advertisement.getImgUrl());
        advertisementRequest.setAdIsActive(true);
        return advertisementRequest;

    }




    //update method with advertisement class
    /*public Advertisement updateAdvertisement(String id, Advertisement updatedAdvertisement) throws Exception {
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
                        existingAdvertisement.setActive(false);
                    }
                    return advertisementRepository.save(existingAdvertisement);

                })
                .orElseThrow(()-> new Exception("Advertisement with id: "+ id + " was not found to update!"));
    }*/

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

    //Get advertisement list by date that is created at after the date
    public List<Advertisement> findAdvertisementByCreatedAtAfter(Date startedDate, Date endDate){
        return advertisementRepository.findAdvertisementByCreatedAtAfter(startedDate, endDate);
    }

    //Get advertisement list by date that is created at before the date
    public List<Advertisement> findAdvertisementByCreatedAtBefore(Date startedDate, Date endDate){
        return advertisementRepository.findAdvertisementByCreatedAtBefore(startedDate,endDate);
    }



}