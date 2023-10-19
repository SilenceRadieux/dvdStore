package org.dvdstore.backpostgre.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name ="dvd_cart")
public class CartDvdRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    public CartRepositoryModel id_cart;

    @Column
    private long id_dvd;

    @Column
    private long quantity;

    @Column
    private long price;


}
