package com.musabProject.restaurantReview.services;


import com.musabProject.restaurantReview.domain.RestaurantCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.entities.Restaurant;

public interface RestaurantService {

    Restaurant createRestaurant(RestaurantCreateUpdateRequest request);
}
