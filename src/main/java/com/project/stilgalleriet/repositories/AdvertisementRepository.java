package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {

    List<Advertisement> findAdvertisementByActive(boolean advertisementIsActive);
    List<Advertisement> findAdvertisementByCategory(ECategory advertisementCategory);
    List<Advertisement> findAdvertisementByTitle(String advertisementTitle );
    List <Advertisement> findAdvertisementByGender(EGender advertisementGender);
    List <Advertisement> findAdvertisementBySize(ESize advertisementSize);
    List <Advertisement> findAdvertisementByColor (EColor advertisementColor);
    List <Advertisement> findAdvertisementByPriceLessThan(double maxPrice);
    List<Advertisement> findAdvertisementByPriceGreaterThan(double minPrice);
    List <Advertisement> findAdvertisementByPriceBetween(double minPrice, double maxPrice);




}
