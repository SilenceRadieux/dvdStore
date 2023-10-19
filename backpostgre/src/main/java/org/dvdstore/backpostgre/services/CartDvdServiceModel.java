package org.dvdstore.backpostgre.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDvdServiceModel {

    private long id_cart;
    private long id_dvd;
    private long quantity;
    private long price;

}
