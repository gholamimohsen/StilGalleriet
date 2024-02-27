package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {
}
