package com.saheed.JobApp.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.saheed.JobApp.reviews.ReviewService;

import java.util.List;
@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")

    public ResponseEntity<List<Review>>getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
       boolean isRevirewSaved = reviewService.addReview(companyId, review);
       if(isRevirewSaved)
        return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
       else
           return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyID,
                                            @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyID,
                reviewId), HttpStatus.OK);
    }
}
