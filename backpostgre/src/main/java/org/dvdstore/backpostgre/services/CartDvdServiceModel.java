package org.dvdstore.backpostgre.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDvdServiceModel {

    private Long idCart;
    private Long idDvd;
    private Long quantity;
    private Long price;

}
