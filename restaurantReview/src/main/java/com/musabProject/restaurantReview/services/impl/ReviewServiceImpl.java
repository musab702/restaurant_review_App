package com.musabProject.restaurantReview.services.impl;

import com.musabProject.restaurantReview.domain.ReviewCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.entities.Photo;
import com.musabProject.restaurantReview.domain.entities.Restaurant;
import com.musabProject.restaurantReview.domain.entities.Review;
import com.musabProject.restaurantReview.domain.entities.User;
import com.musabProject.restaurantReview.exceptions.RestaurantNotFoundException;
import com.musabProject.restaurantReview.exceptions.ReviewNotAllowedException;
import com.musabProject.restaurantReview.repositories.RestaurantRepository;
import com.musabProject.restaurantReview.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review){
        Restaurant restaurant = getRestaurantOrThrow(restaurantId);

        boolean hasExistingReview = restaurant.getReviews()
                .stream()
                .anyMatch(r -> r.getWrittenBy().getId().equals(author.getId()));

        if (hasExistingReview) {
            throw new ReviewNotAllowedException("User has already reviewed this restaurant");
        }

        LocalDateTime now = LocalDateTime.now();

        List<Photo> photos = review.getPhotoIds().stream().map(url -> {
            return Photo.builder()
                    .url(url)
                    .uploadDate(now)
                    .build();
        }).toList();

        String reviewId = UUID.randomUUID().toString();

        Review reviewToCreate = Review.builder()
                .id(reviewId)
                .content(review.getContent())
                .rating(review.getRating())
                .photos(photos)
                .datePosted(now)
                .lastEdited(now)
                .writtenBy(author)
                .build();


        restaurant.getReviews().add(reviewToCreate);
        updateRestaurantAverageRating(restaurant);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return savedRestaurant.getReviews().stream()
                .filter(r->reviewId.equals(r.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error retrieving created review"));


    }

    private Restaurant getRestaurantOrThrow(String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException(
                        "Restaurant with id not found: " + restaurantId));
    }

    private void updateRestaurantAverageRating(Restaurant restaurant){
        List<Review> reviews = restaurant.getReviews();
        if (reviews.isEmpty()){
            restaurant.setAverageRating(0.0f);
        }else{
            double averageRating = reviews.stream().mapToDouble(Review::getRating)
                    .average()
                    .orElse(0.0);

            restaurant.setAverageRating((float) averageRating);
        }

    }

}
