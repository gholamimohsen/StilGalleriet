package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Maybe remove this later, check comment in ReviewService
    @GetMapping("/all")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @PutMapping()
    public ResponseEntity<?> updateReview(@PathVariable String id, @Valid @RequestBody Review review){

        Review updatedReview = reviewService.updateReview(id, review);
        return ResponseEntity.ok(updatedReview);
    }
}
