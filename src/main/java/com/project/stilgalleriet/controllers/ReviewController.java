package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id){
        Optional<Review> review = reviewService.getReviewById(id); //Optional prevents null value
        return review.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build()); //Return status code 404 if review is not found
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable String id, @Valid @RequestBody Review review){

        Review updatedReview = reviewService.updateReview(id, review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id){
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Deleted review: " + id);
    }
}
