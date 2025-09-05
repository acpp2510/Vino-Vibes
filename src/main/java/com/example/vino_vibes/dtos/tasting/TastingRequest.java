package com.example.vino_vibes.dtos.tasting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

public record TastingRequest(
        @NotNull(message = "tastingDate must not be null")
        @Size(min = 10, max = 10, message = "tastingDate must be 10 characters")
        @PastOrPresent(message = "The tasting date cannot be in the future.")
        LocalDate tastingDate,

        @NotBlank(message = "aromaDescription must not be blank")
        @Size(min = 5, max = 150, message = "aromaDescription must be between 5 and 100 characters")
        String aromaDescription,

        @NotBlank(message = "colorDescription must not be blank")
        @Size(min = 5, max = 150, message = "colorDescription must be between 5 and 100 characters")
        String colorDescription,

        @NotBlank(message = "tasteDescription must not be blank")
        @Size(min = 5, max = 150, message = "tasteDescription must be between 5 and 100 characters")
        String tasteDescription,

        @NotBlank(message = "emotionsEvoked must not be blank")
        @Size(min = 5, max = 150, message = "emotionsEvoked must be between 5 and 100 characters")
        String emotionsEvoked,

        @NotBlank(message = "pairing must not be blank")
        @Size(min = 5, max = 150, message = "pairing must be between 5 and 100 characters")
        String pairing,

        @NotBlank(message = "imageTasting must not be blank")
        @URL(message = "Please enter a valid URL")
        String imageTasting
) {
}
