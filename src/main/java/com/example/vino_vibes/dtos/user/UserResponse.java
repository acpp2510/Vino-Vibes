package com.example.vino_vibes.dtos.user;

public record UserResponse(
        Long id,
        String username,
        String email,
        String role
) {
}
