package com.example.vino_vibes.models;

import jakarta.persistence.*;

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


}
