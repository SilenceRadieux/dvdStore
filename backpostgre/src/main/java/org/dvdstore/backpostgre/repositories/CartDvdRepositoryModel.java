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
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartDvdRepositoryModels")
    public CartRepositoryModel cart;

    @Column(name = "id_cart", columnDefinition = "BIGINT")
    public Long idCart;

    @Column(name = "id_dvd", columnDefinition = "BIGINT")
    private Long idDvd;

    @Column(columnDefinition = "BIGINT")
    private Long quantity;

    @Column(columnDefinition = "BIGINT")
    private Long price;

}
