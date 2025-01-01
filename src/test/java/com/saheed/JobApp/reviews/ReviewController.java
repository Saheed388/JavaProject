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
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review){
       boolean isReviewSaved = reviewService.addReview(companyId, review);
       if(isReviewSaved)
        return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
       else
           return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId,
                reviewId), HttpStatus.OK);
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long reviewId,
                                                @PathVariable Long companyId) {
        boolean isReviewdeleted = reviewService.deleteReview(companyId, reviewId);
        if (isReviewdeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);

        }
    }
    
    @PutMapping("/reviews/{reviewId}")
        public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                @PathVariable Long companyId,
                @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(companyId,
                reviewId, review);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("No Review Found", HttpStatus.NOT_FOUND);

    }
    }

