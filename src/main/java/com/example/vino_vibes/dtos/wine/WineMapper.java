package com.example.vino_vibes.dtos.wine;

import com.example.vino_vibes.dtos.user.UserMapper;
import com.example.vino_vibes.dtos.user.UserResponse;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.models.Wine;

public class WineMapper {

    public static Wine toEntity(WineRequest request, User user) {
        return new Wine(
                request.wineName(),
                request.alcoholContent(),
                request.wineType(),
                request.year(),
                request.grapeVariety(),
                request.region(),
                request.wineProducer(),
                request.urlProducer(),
                user
        );
    }

    public static WineResponse toDto(Wine wine) {
        UserResponse userResponse = wine.getUser() != null
                ? UserMapper.toDto(wine.getUser())
                : null;
        return new WineResponse(
                wine.getId(),
                wine.getWineName(),
                wine.getAlcoholContent(),
                wine.getWineType(),
                wine.getYear(),
                wine.getGrapeVariety(),
                wine.getRegion(),
                wine.getWineProducer(),
                wine.getUrlProducer(),
                userResponse
        );
    }

}
