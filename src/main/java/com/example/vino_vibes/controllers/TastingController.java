package com.example.vino_vibes.controllers;

import com.example.vino_vibes.dtos.tasting.TastingRequest;
import com.example.vino_vibes.dtos.tasting.TastingResponse;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.services.TastingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasting")
public class TastingController {

    private final TastingService tastingService;
    public TastingController(TastingService tastingService) {
        this.tastingService = tastingService;
    }

    @GetMapping("")
    public ResponseEntity<List<TastingResponse>> getAllTastings() {
        List<TastingResponse> tastings = tastingService.getAllTastings();
        return new ResponseEntity<>(tastings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TastingResponse> getTastingById(@PathVariable Long id) {
        TastingResponse tastingResponse = tastingService.getTastingById(id);
        return new ResponseEntity<>(tastingResponse, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<TastingResponse>> getTastingsOfUser(User user) {
        List<TastingResponse> tastings = tastingService.getTastingsOfUser(user.getId(), user);
        return new ResponseEntity<>(tastings, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TastingResponse>> getTastingsOfUser(@PathVariable Long userId, User user) {
        List<TastingResponse> tastings = tastingService.getTastingsOfUser(userId, user);
        return new ResponseEntity<>(tastings, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<TastingResponse> addTasting(@Valid @RequestBody TastingRequest tastingRequest,Long wineId, User user) {
        TastingResponse createdTasting = tastingService.addTasting(tastingRequest,wineId, user);
        return new ResponseEntity<>(createdTasting, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TastingResponse> updateTasting(@PathVariable Long id, @Valid @RequestBody TastingRequest tastingRequest, User user) {
        TastingResponse updateTasting = tastingService.updateTasting(id, tastingRequest, user);
        return ResponseEntity.ok(updateTasting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTasting(@PathVariable Long id, User user) {
        tastingService.deleteTasting(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<TastingResponse>> getTastingByRegion(@PathVariable String region) {
        List<TastingResponse> tastingResponse = tastingService.getTastingsByRegion(region);
        return new ResponseEntity<>(tastingResponse, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<TastingResponse>> getTastingByCity(@PathVariable String type) {
        List<TastingResponse> tastingResponse = tastingService.getTastingsByWineType(type);
        return new ResponseEntity<>(tastingResponse, HttpStatus.OK);
    }

    @GetMapping("/type/{producer}")
    public ResponseEntity<List<TastingResponse>> getTastingByCountry(@PathVariable String producer) {
        List<TastingResponse> tastingResponse = tastingService.getTastingsByWineProducer(producer);
        return new ResponseEntity<>(tastingResponse, HttpStatus.OK);
    }
}
