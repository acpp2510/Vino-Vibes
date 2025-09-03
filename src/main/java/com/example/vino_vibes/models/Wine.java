package com.example.vino_vibes.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wines")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String wineName;

    @Column(nullable = false, length = 20)
    private Double alcoholContent;

    @Column(nullable = false, length = 50)
    private String wineType;

    @Column(nullable = false, length = 4)
    private Integer year;

    @Column(nullable = false, length = 50)
    private String grapeVariety;

    @Column(nullable = false, length = 50)
    private String region;

    @Column(nullable = false, length = 80)
    private String wineProducer;

    @Column(nullable = false, length = 80)
    private String urlProducer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tasting> tastings;

    public Wine() {
    }

    public Wine(String wineName, Double alcoholContent, String wineType, Integer year, String grapeVariety, String region, String wineProducer, String urlProducer, User user) {
        this.wineName = wineName;
        this.alcoholContent = alcoholContent;
        this.wineType = wineType;
        this.year = year;
        this.grapeVariety = grapeVariety;
        this.region = region;
        this.wineProducer = wineProducer;
        this.urlProducer = urlProducer;
        this.user = user;
    }

    public Wine(Long id, String wineName, Double alcoholContent, String wineType, Integer year, String grapeVariety, String region, String wineProducer, String urlProducer, User user) {
        this.id = id;
        this.wineName = wineName;
        this.alcoholContent = alcoholContent;
        this.wineType = wineType;
        this.year = year;
        this.grapeVariety = grapeVariety;
        this.region = region;
        this.wineProducer = wineProducer;
        this.urlProducer = urlProducer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public Double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(Double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGrapeVariety() {
        return grapeVariety;
    }

    public void setGrapeVariety(String grapeVariety) {
        this.grapeVariety = grapeVariety;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWineProducer() {
        return wineProducer;
    }

    public void setWineProducer(String wineProducer) {
        this.wineProducer = wineProducer;
    }

    public String getUrlProducer() {
        return urlProducer;
    }

    public void setUrlProducer(String urlProducer) {
        this.urlProducer = urlProducer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
