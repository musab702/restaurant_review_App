package com.musabProject.restaurantReview.mappers;


import com.musabProject.restaurantReview.domain.RestaurantCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.dtos.GeoPointDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.musabProject.restaurantReview.domain.dtos.RestaurantDto;
import com.musabProject.restaurantReview.domain.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeopointDto(GeoPoint geoPoint);
}
