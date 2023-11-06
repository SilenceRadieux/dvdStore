package org.dvdstore.backpostgre.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartServiceModel {

    private long client;
    private long total_price;

}
