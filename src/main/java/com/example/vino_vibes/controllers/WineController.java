package com.example.vino_vibes.controllers;

import com.example.vino_vibes.dtos.wine.WineRequest;
import com.example.vino_vibes.dtos.wine.WineResponse;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.services.WineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wines")
public class WineController {

    private final WineService wineService;
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("")
    public ResponseEntity<List<WineResponse>> getAllWines() {
        List<WineResponse> wines = wineService.getAllWines();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineResponse> getWineById(@PathVariable Long id) {
        WineResponse wineResponse = wineService.getWineById(id);
        return new ResponseEntity<>(wineResponse, HttpStatus.OK);
    }

    @GetMapping("/wines/user")
    public ResponseEntity<List<WineResponse>> getWinesOfUser(User user) {
        List<WineResponse> wines = wineService.getWinesOfUser(user.getId(), user);
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WineResponse>> getWinesOfUser(@PathVariable Long userId, User user) {
        List<WineResponse> wines = wineService.getWinesOfUser(userId, user);
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<WineResponse> addWine(@Valid @RequestBody WineRequest wineRequest, User user) {
        WineResponse createdWine = wineService.addWine(wineRequest, user);
        return new ResponseEntity<>(createdWine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WineResponse> updateWine(@PathVariable Long id, @Valid @RequestBody WineRequest wineRequest, User user) {
        WineResponse updateWine = wineService.updateWine(id, wineRequest, user);
        return ResponseEntity.ok(updateWine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWine(@PathVariable Long id, User user) {
        wineService.deleteWine(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{region}")
    public ResponseEntity<List<WineResponse>> getWineByRegion(@PathVariable String region) {
        List<WineResponse> wineResponse = wineService.getWinesByRegion(region);
        return new ResponseEntity<>(wineResponse, HttpStatus.OK);
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<WineResponse>> getWineByCity(@PathVariable String type) {
        List<WineResponse> wineResponse = wineService.getWinesByType(type);
        return new ResponseEntity<>(wineResponse, HttpStatus.OK);
    }

    @GetMapping("/{producer}")
    public ResponseEntity<List<WineResponse>> getWineByCountry(@PathVariable String producer) {
        List<WineResponse> wineResponse = wineService.getWinesByProducer(producer);
        return new ResponseEntity<>(wineResponse, HttpStatus.OK);
    }
}
