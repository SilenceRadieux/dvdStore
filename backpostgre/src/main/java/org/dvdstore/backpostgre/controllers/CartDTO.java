package org.dvdstore.backpostgre.controllers;

public record CartDTO(long id, long client, long total_price) {
}
