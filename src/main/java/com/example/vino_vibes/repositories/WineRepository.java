package com.example.vino_vibes.repositories;

import com.example.vino_vibes.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository  extends JpaRepository <Wine, Long> {
}
