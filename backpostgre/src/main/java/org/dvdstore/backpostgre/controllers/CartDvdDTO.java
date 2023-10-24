package org.dvdstore.backpostgre.controllers;

public record CartDvdDTO(long id_client, long id_dvd, int quantity, int price) {
}
