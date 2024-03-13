package com.project.stilgalleriet.controllers;

import com.project.stilgalleriet.dto.ReviewDTO;
import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@Valid @RequestBody ReviewDTO reviewDTO){
        ReviewDTO newReview = reviewService.createReview(reviewDTO); //Change to take user IDs from orders and put it in Review object
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    //Maybe remove this later, check comment in ReviewService
    @GetMapping("/all")
    public List<ReviewDTO> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable String id){
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return new ResponseEntity<>(reviewDTO, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable String id, @Valid @RequestBody Review review){

        ReviewDTO updatedReview = reviewService.updateReview(id, review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id){
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Deleted review: " + id);
    }

    @GetMapping("/find/{id}")
    public List<ReviewDTO> findReviewByRatedUserId(@PathVariable String id){
        return reviewService.getReviewBySeller(id);
    }
}

