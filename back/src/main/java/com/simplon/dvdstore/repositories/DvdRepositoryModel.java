package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dvd")
public class DvdRepositoryModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "isan", unique = true, nullable = false)
  private String isan;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "genre", nullable = false)
  private String genre;

  @Column(name = "directedBy", nullable = false)
  private String directedBy;

  @Column(name = "duration", nullable = false)
  private Integer duration;

  @Column(name = "releaseDate", nullable = false)
  private String releaseDate;

  @Column(name = "synopsis", nullable = false)
  private String synopsis;

  @Column(name = "cover", nullable = false)
  private String cover;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @OneToMany(mappedBy = "dvd")
  private Set<SaleRepositoryModel> recordings = new HashSet<>();

}
