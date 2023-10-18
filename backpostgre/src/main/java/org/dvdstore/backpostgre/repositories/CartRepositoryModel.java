package org.dvdstore.backpostgre.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name ="cart")
public class CartRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_client")
    private long client;

    @Column
    private long total_price;

}
