package com.example.vino_vibes.dtos.tasting;

import com.example.vino_vibes.dtos.user.UserMapper;
import com.example.vino_vibes.dtos.user.UserResponse;
import com.example.vino_vibes.dtos.wine.WineMapper;
import com.example.vino_vibes.dtos.wine.WineResponse;
import com.example.vino_vibes.models.Tasting;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.models.Wine;

public class TastingMapper {

    public static Tasting toEntity(TastingRequest request, Wine wine, User user) {
        return new Tasting(
                request.tastingDate(),
                request.aromaDescription(),
                request.colorDescription(),
                request.tasteDescription(),
                request.emotionsEvoked(),
                request.pairing(),
                request.imageTasting(),
                user,
                wine
        );
    }

    public static TastingResponse toDto(Tasting tasting) {
        UserResponse userResponse = tasting.getUser() != null
                ? UserMapper.toDto(tasting.getUser())
                : null;
        WineResponse wineResponse = tasting.getWine() != null
                ? WineMapper.toDto(tasting.getWine())
                : null;
        return new TastingResponse(
                tasting.getId(),
                tasting.getTastingDate(),
                tasting.getAromaDescription(),
                tasting.getColorDescription(),
                tasting.getTasteDescription(),
                tasting.getEmotionsEvoked(),
                tasting.getPairing(),
                tasting.getImageTasting(),
                wineResponse,
                userResponse
        );
    }
}
