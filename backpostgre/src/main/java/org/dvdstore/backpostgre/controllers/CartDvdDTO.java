package org.dvdstore.backpostgre.controllers;

public record CartDvdDTO(long cart, long id_dvd, int quantity, int price) {
}
