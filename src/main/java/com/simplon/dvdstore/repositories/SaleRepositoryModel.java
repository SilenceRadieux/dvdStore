package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sale")
public class SaleRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientRepositoryModel client ;

    @ManyToOne
    @JoinColumn(name = "dvd_id")
    private DvdRepositoryModel dvd;

    private int quantity;

    public SaleRepositoryModel(ClientRepositoryModel client, DvdRepositoryModel dvd) {
    }


    public SaleRepositoryModel(ClientRepositoryModel client, DvdRepositoryModel dvd, int quantity) {
        this.client = client;
        this.dvd = dvd;
        this.quantity = quantity;
    }
}
