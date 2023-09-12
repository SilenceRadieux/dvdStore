package com.simplon.dvdstore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dvd")
public class DvdModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column( nullable = false, length = 255)
    private String genre;

    public DvdModel() {

    }

    public DvdModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
