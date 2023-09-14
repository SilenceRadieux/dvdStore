package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleServiceModel {

    private long idClient;
    private long idDvd;
    private int quantity;

}
