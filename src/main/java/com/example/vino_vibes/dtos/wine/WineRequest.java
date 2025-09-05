package com.example.vino_vibes.dtos.wine;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.Year;

public record WineRequest(
        @NotBlank(message = "Winename must not be blank")
        @Size(min = 5, max = 100, message = "Winename must be between 5 and 100 characters")
        String wineName,

        @NotNull(message = "Alcoholcontent must not be null")
        @Positive(message = "Alcoholcontent must be a positive value.")
        @Digits(integer = 2, fraction = 2, message = "Alcoholcontent must contain only numbers")
        Double alcoholContent,

        @NotBlank(message = "Winetype must not be blank")
        @Size(min = 5, max = 100, message = "Winetype must be between 5 and 100 characters")
        String wineType,

        @NotNull(message = "Year must not be null")
        @Positive(message = "Year must be a positive value.")
        @PastOrPresent(message = "Year cannot be in the future.")
        @Min(value = 1900, message = "Year must be between 1900 and 2025")
        @Max(value = 2025, message = "Year must be between 1900 and 2025")
        Integer year,

        @NotBlank(message = "Grapevariety must not be blank")
        @Size(min = 5, max = 100, message = "Grapevariety must be between 5 and 100 characters")
        String grapeVariety,

        @NotBlank(message = "Region must not be blank")
        @Size(min = 5, max = 100, message = "Region must be between 5 and 100 characters")
        String region,

        @NotBlank(message = "Wineproducer must not be blank")
        @Size(min = 5, max = 100, message = "Wineproducer must be between 5 and 100 characters")
        String wineProducer,

        @NotBlank(message = "Urlproducer must not be blank")
        @URL(message = "Please enter a valid URL")
        String urlProducer
) {
}
