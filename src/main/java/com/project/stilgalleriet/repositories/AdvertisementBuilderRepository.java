package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.AdvertisementBuilder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertisementBuilderRepository extends MongoRepository<AdvertisementBuilder,String> {
}
