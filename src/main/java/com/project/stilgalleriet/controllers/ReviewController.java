package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stilgalleriet/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@Valid @RequestBody Review review){
        Review newReview = reviewService.addReview(review); //Change to take user IDs from orders and put it in Review object
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
}
