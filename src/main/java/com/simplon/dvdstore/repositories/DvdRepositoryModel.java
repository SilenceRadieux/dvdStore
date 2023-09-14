package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "quantity", nullable = false, length = 255)
    private Integer quantity;

    @OneToMany(mappedBy = "dvd")
    private Set<SaleRepositoryModel> recordings = new HashSet<>();

    public DvdRepositoryModel() {

    }

    public DvdRepositoryModel(String name, String genre, int quantity) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
    }

}
