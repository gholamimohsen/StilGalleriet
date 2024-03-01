package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {

    List<Advertisement> findAdvertisementById(String advertisementId);
    List<Advertisement> findAdvertisementByActive(Boolean advertisementIsActive);
    List<Advertisement> findAdvertisementByCategory(ECategory advertisementCategory);

    List<Advertisement> findAdvertisementByTitle(String advertisementTitle );
    List <Advertisement> findAdvertisementByGender(EGender advertisementGender);
    List <Advertisement> findAdvertisementBySize(ESize advertisementSize);
    List <Advertisement> findAdvertisementByColor (EColor advertisementColor);




}
