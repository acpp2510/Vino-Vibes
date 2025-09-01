package com.example.vino_vibes.dtos.wine;

import com.example.vino_vibes.dtos.user.UserResponse;
import jakarta.persistence.Column;

public record WineResponse(
        Long id,
        String wineName,
        Double alcoholContent,
        String wineType,
        Integer year,
        String grapeVariety,
        String region,
        String wineProducer,
        String urlProducer,
        UserResponse user
) {
}
