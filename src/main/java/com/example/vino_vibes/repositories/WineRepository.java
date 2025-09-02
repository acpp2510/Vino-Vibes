package com.example.vino_vibes.repositories;

import com.example.vino_vibes.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository  extends JpaRepository <Wine, Long> {
    List<Wine> findByUserId(Long userId);

    Boolean existsByWineNameAndWineProducerAndYear(String wineName, String wineProducer, Integer year);

    List<Wine> findByRegion(String region);

    List<Wine> findByWineType(String wineType);

    List<Wine> findByWineProducer(String wineProducer);
}
