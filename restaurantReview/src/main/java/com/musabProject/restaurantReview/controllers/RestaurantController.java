package com.musabProject.restaurantReview.controllers;

import com.musabProject.restaurantReview.domain.RestaurantCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantDto;
import com.musabProject.restaurantReview.domain.entities.Restaurant;
import com.musabProject.restaurantReview.mappers.RestaurantMapper;
import com.musabProject.restaurantReview.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(
            @Valid @RequestBody RestaurantCreateUpdateRequestDto request
    ){
        RestaurantCreateUpdateRequest restaurantCreateUpdateRequest = restaurantMapper
                .toRestaurantCreateUpdateRequest(request);

        Restaurant restaurant = restaurantService.createRestaurant(restaurantCreateUpdateRequest);

        RestaurantDto createdRestaurantDto = restaurantMapper.toRestaurantDto(restaurant);
        return ResponseEntity.ok(createdRestaurantDto);
    }

}
