package com.example.vino_vibes.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tastings")
public class Tasting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private LocalDate tastingDate;

    @Column(nullable = false, length = 150)
    private String aromaDescription;

    @Column(nullable = false, length = 150)
    private String colorDescription;

    @Column(nullable = false, length = 150)
    private String tasteDescription;

    @Column(nullable = false, length = 250)
    private String emotionsEvoked;

    @Column(nullable = false, length = 150)
    private String pairing;

    @Column(nullable = false, length = 250)
    private String imageTasting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    public Tasting() {
    }

    public Tasting(LocalDate tastingDate, String aromaDescription, String colorDescription, String tasteDescription, String emotionsEvoked, String pairing, String imageTasting, User user, Wine wine) {
        this.tastingDate = tastingDate;
        this.aromaDescription = aromaDescription;
        this.colorDescription = colorDescription;
        this.tasteDescription = tasteDescription;
        this.emotionsEvoked = emotionsEvoked;
        this.pairing = pairing;
        this.imageTasting = imageTasting;
        this.user = user;
        this.wine = wine;
    }

    public Tasting(Long id, LocalDate tastingDate, String aromaDescription, String colorDescription, String tasteDescription, String emotionsEvoked, String pairing, String imageTasting, User user, Wine wine) {
        this.id = id;
        this.tastingDate = tastingDate;
        this.aromaDescription = aromaDescription;
        this.colorDescription = colorDescription;
        this.tasteDescription = tasteDescription;
        this.emotionsEvoked = emotionsEvoked;
        this.pairing = pairing;
        this.imageTasting = imageTasting;
        this.user = user;
        this.wine = wine;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getTastingDate() {
        return tastingDate;
    }

    public void setTastingDate(LocalDate tastingDate) {
        this.tastingDate = tastingDate;
    }

    public String getAromaDescription() {
        return aromaDescription;
    }

    public void setAromaDescription(String aromaDescription) {
        this.aromaDescription = aromaDescription;
    }

    public String getColorDescription() {
        return colorDescription;
    }

    public void setColorDescription(String colorDescription) {
        this.colorDescription = colorDescription;
    }

    public String getTasteDescription() {
        return tasteDescription;
    }

    public void setTasteDescription(String tasteDescription) {
        this.tasteDescription = tasteDescription;
    }

    public String getEmotionsEvoked() {
        return emotionsEvoked;
    }

    public void setEmotionsEvoked(String emotionsEvoked) {
        this.emotionsEvoked = emotionsEvoked;
    }

    public String getPairing() {
        return pairing;
    }

    public void setPairing(String pairing) {
        this.pairing = pairing;
    }

    public String getImageTasting() {
        return imageTasting;
    }

    public void setImageTasting(String imageTasting) {
        this.imageTasting = imageTasting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }
}
