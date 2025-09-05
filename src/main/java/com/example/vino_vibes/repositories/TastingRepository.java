package com.example.vino_vibes.repositories;

import com.example.vino_vibes.models.Tasting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TastingRepository extends JpaRepository<Tasting, Long> {
    List<Tasting> findByUserId(Long userId);

    List<Tasting> findByWine_Region(String region);

    List<Tasting> findByWine_WineType(String wineType);

    List<Tasting> findByWine_WineProducer(String wineProducer);
}
