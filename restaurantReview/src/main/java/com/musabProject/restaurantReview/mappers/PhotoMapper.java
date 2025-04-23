package com.musabProject.restaurantReview.mappers;

import com.musabProject.restaurantReview.domain.dtos.PhotoDto;
import com.musabProject.restaurantReview.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

    PhotoDto toDto(Photo photo);

}
