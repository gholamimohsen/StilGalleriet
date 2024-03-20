package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Followers;
import com.project.stilgalleriet.repositories.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowersService {

    @Autowired
    FollowersRepository followersRepository;

    //POST
    public Followers createFollower(Followers followers) {
        return followersRepository.save(followers);

    }

    //GET
    public List<Followers> getAllFollowers(){
        return followersRepository.findAll();
    }

    //GET BY ID
    public Followers getFollowerById(String id) {
        return followersRepository.findById(id).get();
    }

    //UPDATE
    public Followers updateFollower(String id, Followers updatedFollower){
        return followersRepository.findById(id).map(followers -> {
            followers.setFollowedUserId(updatedFollower.getFollowedUserId());
            followers.setFollowingUserId(updatedFollower.getFollowingUserId());
            return followersRepository.save(followers);
        })
                .orElseThrow();
    }

    //DELETE
    public String deleteFollower(String id) {
        followersRepository.deleteById(id);
        return "Follower deleted!";
    }



}
