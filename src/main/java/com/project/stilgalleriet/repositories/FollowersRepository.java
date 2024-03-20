package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Followers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowersRepository extends MongoRepository<Followers, String> {

}
