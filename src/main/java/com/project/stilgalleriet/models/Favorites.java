package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;


public class Favorites {

    @Id
    private String id;



    private User userIdFav;

    private Advertisement advertisementId;


    public Favorites() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserIdFav() {
        return userIdFav;
    }

    public void setUserIdFav(User userIdFav) {
        this.userIdFav = userIdFav;
    }

    public Advertisement getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Advertisement advertisementId) {
        this.advertisementId = advertisementId;
    }
}
