package com.musabProject.restaurantReview.services;

import com.musabProject.restaurantReview.domain.ReviewCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.entities.Review;
import com.musabProject.restaurantReview.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);

    Page<Review> listReviews(String restaurantId, Pageable pageable);

    Optional<Review> getReview(String restaurantId, String reviewId);

    Review updateReview(User author, String restaurantId, String reviewId, ReviewCreateUpdateRequest review);

}
