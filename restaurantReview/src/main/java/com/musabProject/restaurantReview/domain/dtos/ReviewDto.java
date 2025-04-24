package com.musabProject.restaurantReview.domain.dtos;

import com.musabProject.restaurantReview.domain.entities.Photo;
import com.musabProject.restaurantReview.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private String id;

    private String content;

    private Integer rating;

    private LocalDateTime datePosted;

    private LocalDateTime lastEdited;

    private List<Photo> photos = new ArrayList<>();

    private UserDto writtenBy;
}
