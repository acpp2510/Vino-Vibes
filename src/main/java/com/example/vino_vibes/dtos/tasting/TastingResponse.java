package com.example.vino_vibes.dtos.tasting;

import com.example.vino_vibes.dtos.user.UserResponse;
import com.example.vino_vibes.dtos.wine.WineResponse;

import java.time.LocalDate;

public record TastingResponse(
        Long id,
        LocalDate tastingDate,
        String aromaDescription,
        String colorDescription,
        String tasteDescription,
        String emotionsEvoked,
        String pairing,
        String imageTasting,
        WineResponse wine,
        UserResponse user
) {
}
