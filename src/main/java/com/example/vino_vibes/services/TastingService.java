package com.example.vino_vibes.services;

import com.example.vino_vibes.dtos.tasting.TastingMapper;
import com.example.vino_vibes.dtos.tasting.TastingResponse;
import com.example.vino_vibes.dtos.tasting.TastingRequest;
import com.example.vino_vibes.exceptions.EntityNotFoundException;
import com.example.vino_vibes.models.*;
import com.example.vino_vibes.models.Tasting;
import com.example.vino_vibes.repositories.TastingRepository;
import com.example.vino_vibes.repositories.UserRepository;
import com.example.vino_vibes.repositories.WineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TastingService {
    private final TastingRepository tastingRepository;
    private final WineRepository wineRepository;
    private final UserRepository userRepository;

    public TastingService(TastingRepository tastingRepository, WineRepository wineRepository, UserRepository userRepository) {
        this.tastingRepository = tastingRepository;
        this.wineRepository = wineRepository;
        this.userRepository = userRepository;
    }


    public List<TastingResponse> getAllTastings() {
        List<Tasting> tastings = tastingRepository.findAll();
        return tastings.stream()
                .map(TastingMapper::toDto)
                .toList();
    }

    public TastingResponse getTastingById(Long id) {
        Tasting tasting = tastingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Tasting.class.getSimpleName(), "id", id.toString()));
        return TastingMapper.toDto(tasting);
    }

    public List<TastingResponse> getTastingsOfUser(Long userId, User user) {
        List<Tasting> tastings = tastingRepository.findByUserId(userId);
        return tastings.stream()
                .map(TastingMapper::toDto)
                .toList();
    }

    public TastingResponse addTasting(TastingRequest tastingRequest, Long wineId,User user) {
        Wine wine = wineRepository.findById(wineId)
                .orElseThrow(() -> new EntityNotFoundException(Wine.class.getSimpleName(), "id", wineId.toString()));

        Tasting newTasting = TastingMapper.toEntity(tastingRequest, wine, user);
        Tasting savedTasting = tastingRepository.save(newTasting);
        return TastingMapper.toDto(savedTasting);
    }

    public TastingResponse updateTasting(Long id, TastingRequest tastingRequest, User user) {
        Tasting tasting = tastingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Tasting.class.getSimpleName(), "id", id.toString()));
        if (!user.getRole().equals(Role.ADMIN) && !tasting.getUser().getId().equals(user.getId())) {
            throw new SecurityException("You do not have permission to update this tasting.");
        }
        tasting.setTastingDate(tastingRequest.tastingDate());
        tasting.setAromaDescription(tastingRequest.aromaDescription());
        tasting.setColorDescription(tastingRequest.colorDescription());
        tasting.setTasteDescription(tastingRequest.tasteDescription());
        tasting.setEmotionsEvoked(tastingRequest.emotionsEvoked());
        tasting.setPairing(tastingRequest.pairing());
        tasting.setImageTasting(tastingRequest.imageTasting());

        Tasting updatedTasting = tastingRepository.save(tasting);
        return TastingMapper.toDto(updatedTasting);
    }

    public void deleteTasting(Long id, User user) {
        Tasting tasting =tastingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Wine.class.getSimpleName(), "id", id.toString()));
        if (!user.getRole().equals(Role.ADMIN) && !tasting.getUser().getId().equals(user.getId())) {
            throw new SecurityException("You do not have permission to delete this wine.");
        }
        wineRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<TastingResponse> getTastingsByRegion(String region) {
        List<Tasting> tastings = tastingRepository.findByWine_Region(region);
        return tastings.stream()
                .map(TastingMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TastingResponse> getTastingsByWineType(String wineType) {
        List<Tasting> tastings = tastingRepository.findByWine_WineType(wineType);
        return tastings.stream()
                .map(TastingMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TastingResponse> getTastingsByWineProducer(String wineProducer) {
        List<Tasting> tastings = tastingRepository.findByWine_WineProducer(wineProducer);
        return tastings.stream()
                .map(TastingMapper::toDto)
                .toList();
    }
}
