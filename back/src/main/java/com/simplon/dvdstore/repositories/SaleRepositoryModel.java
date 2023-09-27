package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sale")
public class SaleRepositoryModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientRepositoryModel client;

  @ManyToOne
  @JoinColumn(name = "dvd_id")
  private DvdRepositoryModel dvd;

  @Column(name = "quantity")
  private int quantity;

}
