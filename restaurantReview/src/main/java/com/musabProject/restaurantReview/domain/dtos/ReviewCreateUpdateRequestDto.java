package com.musabProject.restaurantReview.domain.dtos;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCreateUpdateRequestDto {

    @NotBlank(message = "Review Content is required")
    private String content;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be between one and five")
    @Max(value = 5, message = "Rating must be between one and five")
    private Integer rating;

    private List<String> photoIds = new ArrayList<>();


}
