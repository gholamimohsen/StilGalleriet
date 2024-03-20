package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "followers")
public class Followers {

    @Id
    private String id;
    private String followingUserId;
    private String followedUserId;


    public Followers() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(String followingUserId) {
        this.followingUserId = followingUserId;
    }

    public String getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(String followedUserId) {
        this.followedUserId = followedUserId;
    }
}
