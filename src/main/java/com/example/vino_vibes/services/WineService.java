package com.example.vino_vibes.services;

import com.example.vino_vibes.dtos.wine.WineMapper;
import com.example.vino_vibes.dtos.wine.WineRequest;
import com.example.vino_vibes.dtos.wine.WineResponse;
import com.example.vino_vibes.exceptions.EntityAlreadyExistsException;
import com.example.vino_vibes.exceptions.EntityNotFoundException;
import com.example.vino_vibes.models.Role;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.models.Wine;
import com.example.vino_vibes.repositories.WineRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WineService {
    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<WineResponse> getAllWines() {
        List<Wine> wines = wineRepository.findAll();
        return wines.stream()
                .map(wine -> WineMapper.toDto(wine))
                .toList();
    }

    public WineResponse getWineById(Long id) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Wine.class.getSimpleName(), "id", id.toString()));
        return WineMapper.toDto(wine);
    }

    public List<WineResponse> getWinesOfUser(Long userId, User user) {
        List<Wine> wines = wineRepository.findByUserId(userId);
        return wines.stream()
                .map(WineMapper::toDto)
                .toList();
    }

    public WineResponse addWine(WineRequest wineRequest, User user) {
        if (wineRepository.existsByWineNameAndWineProducerAndYear(wineRequest.wineName(), wineRequest.wineProducer(), wineRequest.year())) {
            throw new EntityAlreadyExistsException(Wine.class.getSimpleName(), "Winename", wineRequest.wineName());
        }
        Wine newWine = WineMapper.toEntity(wineRequest, user);
        Wine savedWine = wineRepository.save(newWine);
        return WineMapper.toDto(savedWine);
    }

    public WineResponse updateWine(Long id, WineRequest wineRequest, User user) {
        Wine updateWine = wineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Wine.class.getSimpleName(), "id", id.toString()));
        if (!user.getRole().equals(Role.ADMIN) && !updateWine.getUser().getId().equals(user.getId())) {
            throw new SecurityException("You do not have permission to update this wine.");

        }
        updateWine.setWineName(wineRequest.wineName());
        updateWine.setAlcoholContent(wineRequest.alcoholContent());
        updateWine.setWineType(wineRequest.wineType());
        updateWine.setYear(wineRequest.year());
        updateWine.setGrapeVariety(wineRequest.grapeVariety());
        updateWine.setRegion(wineRequest.region());
        updateWine.setWineProducer(wineRequest.wineProducer());
        updateWine.setUrlProducer(wineRequest.urlProducer());
        Wine newWine = wineRepository.save(updateWine);
        return WineMapper.toDto(newWine);
    }


    public void deleteWine(Long id, User user) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Wine.class.getSimpleName(), "id", id.toString()));
        if (!user.getRole().equals(Role.ADMIN) && !wine.getUser().getId().equals(user.getId())) {
            throw new SecurityException("You do not have permission to delete this wine.");
        }
        wineRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<WineResponse> getWinesByRegion(String region) {
        List<Wine> wines = wineRepository.findByRegion(region);
        return wines.stream()
                .map(WineMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<WineResponse> getWinesByType(String wineType) {
        List<Wine> wines = wineRepository.findByWineType(wineType);
        return wines.stream()
                .map(WineMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<WineResponse> getWinesByProducer(String wineProducer) {
        List<Wine> wines = wineRepository.findByWineProducer(wineProducer);
        return wines.stream()
                .map(WineMapper::toDto)
                .toList();
    }
}
