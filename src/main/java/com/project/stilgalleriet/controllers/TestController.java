package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    // publik route = öppen för alla även ej registrerad
    @GetMapping("/all")
    public String allAccess() {
        return "Public content";
    }

    // user route = måste vara minst User roll, du måste vara inloggad

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/user")
    public String userAccess() {
        return "User content!";
    }


    // admin route = en user kan inte komma åt utan måste vara admin roll
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin content!";
    }


}
