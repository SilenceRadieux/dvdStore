package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dvd")
public class DvdRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "genre", nullable = false, length = 255)
    private String genre;

    public DvdRepositoryModel() {

    }

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
