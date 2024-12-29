package com.saheed.JobApp.reviews.implementation;

import com.saheed.JobApp.company.Company;
import com.saheed.JobApp.company.CompanyService;
import com.saheed.JobApp.reviews.Review;
import com.saheed.JobApp.reviews.ReviewRepository;
import com.saheed.JobApp.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImplemantation implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewImplemantation(ReviewRepository reviewRepository,
                                CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if( company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;

        }else {
            return false;
        }

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }


}

