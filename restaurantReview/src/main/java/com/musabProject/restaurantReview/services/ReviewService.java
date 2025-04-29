package com.musabProject.restaurantReview.services;

import com.musabProject.restaurantReview.domain.ReviewCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.entities.Review;
import com.musabProject.restaurantReview.domain.entities.User;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);

}
