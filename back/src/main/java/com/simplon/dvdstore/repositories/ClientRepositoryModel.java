package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Client repository model.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<SaleRepositoryModel> recordings = new HashSet<>();


}
