package org.dvdstore.backpostgre.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartServiceModel {

    private long idClient;
    private long totalPrice;

}
