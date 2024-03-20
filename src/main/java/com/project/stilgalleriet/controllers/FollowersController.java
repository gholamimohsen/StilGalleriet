package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Followers;
import com.project.stilgalleriet.services.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stilgalleriet/followers")
public class FollowersController {
    @Autowired
    private FollowersService followersService;


    //POST
    @PostMapping("/add")
    public Followers createFollower(@RequestBody Followers followers) {
        return followersService.createFollower(followers);

    }

    //GET
    @GetMapping("/all")
    public List<Followers> getAllFollowers() {
        return followersService.getAllFollowers();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Followers getFollowerById(@PathVariable String id) {
        return followersService.getFollowerById(id);
    }

    //PUT
    @PutMapping("/update/{id}")
    public Followers updateFollower(@PathVariable String id, @RequestBody Followers followers) {
        return followersService.updateFollower(id, followers);

    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteFollower(@PathVariable String id) {
        return followersService.deleteFollower(id);
    }
}




















