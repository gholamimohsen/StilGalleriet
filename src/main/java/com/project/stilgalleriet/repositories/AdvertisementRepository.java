package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {

   /* NEW CODES TO FILTER BY ID CATEGORY ETC FOR DTO CLASSES CODE ??

    List<Advertisement> findAdvertisementById(String advertisementId);

    List<Advertisement> findAdvertisementByActive(Boolean advertisementIsActive);
    List<Advertisement> findAdvertisementByCategory(ECategory advertisementCategory);

    List<Advertisement> findAdvertisementByTitle(String advertisementTitle );
    List <Advertisement> findAdvertisementByGender(EGender advertisementGender);
    List <Advertisement> findAdvertisementBySize(ESize advertisementSize);
    List <Advertisement> findAdvertisementByColor (EColor advertisementColor);

*/


}
