package com.musabProject.restaurantReview.domain.dtos;

import com.musabProject.restaurantReview.domain.entities.Address;
import com.musabProject.restaurantReview.domain.entities.OperatingHours;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantCreateUpdateRequestDto {

    @NotBlank(message = "restaurant name is required")
    private String name;

    @NotBlank(message = "cuisine type is required")
    private String cuisineType;

    @NotBlank(message = "contact information is required")
    private String contactInformation;

    @Valid
    private AddressDto address;

    @Valid
    private OperatingHoursDto operatingHours;

    @Size(min = 1, message = "Atleast one photo Id is required")
    private List<String> photoIds;

}
