package org.dvdstore.backpostgre.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name ="cart")
public class CartRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @OneToMany(mappedBy = "cart")
    List<CartDvdRepositoryModel> cartDvdRepositoryModels;

    @Column(name = "id_client", columnDefinition = "BIGINT")
    private Long idClient;

    @Column(name = "total_price", columnDefinition = "BIGINT")
    @Transient
    private Long totalPrice;

}
