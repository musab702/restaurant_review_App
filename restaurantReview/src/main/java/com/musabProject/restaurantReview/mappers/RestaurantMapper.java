package com.musabProject.restaurantReview.mappers;


import com.musabProject.restaurantReview.domain.RestaurantCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.dtos.GeoPointDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantSummaryDto;
import com.musabProject.restaurantReview.domain.entities.Restaurant;
import com.musabProject.restaurantReview.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

    @Named("populateTotalReviews")
    default Integer populateTotalReviews(List<Review> reviews){
        return reviews.size();
    }

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeopointDto(GeoPoint geoPoint);
}
