package com.musabProject.restaurantReview.services;

import com.musabProject.restaurantReview.domain.GeoLocation;
import com.musabProject.restaurantReview.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geolocate(Address address);
}
