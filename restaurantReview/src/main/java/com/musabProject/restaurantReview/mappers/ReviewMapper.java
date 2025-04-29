package com.musabProject.restaurantReview.mappers;


import com.musabProject.restaurantReview.domain.ReviewCreateUpdateRequest;
import com.musabProject.restaurantReview.domain.dtos.ReviewCreateUpdateRequestDto;
import com.musabProject.restaurantReview.domain.dtos.ReviewDto;
import com.musabProject.restaurantReview.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);
}
