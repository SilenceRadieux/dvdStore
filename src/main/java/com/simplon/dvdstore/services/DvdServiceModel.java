package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DvdServiceModel {

    private String name;
    private String genre;
    private int quantity;

}
