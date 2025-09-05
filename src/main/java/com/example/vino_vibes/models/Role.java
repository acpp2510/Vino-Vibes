package com.example.vino_vibes.models;

public enum Role {
    USER,
    ADMIN;

    public String getName() {
        return "ROLE_" + this.name();
    }
}
