package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class ClientRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<SaleRepositoryModel> recordings = new HashSet<>();

    public ClientRepositoryModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
