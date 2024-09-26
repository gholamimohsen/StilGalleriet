package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;

import java.util.List;

public interface AdvertisementFilterStrategy {

    List<Advertisement> filterAdvertisements(AdvertisementService advertisementService);

}
