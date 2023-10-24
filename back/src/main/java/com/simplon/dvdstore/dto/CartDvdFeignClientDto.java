package com.simplon.dvdstore.dto;

public record CartDvdFeignClientDto(long id_client, long id_dvd, int quantity, int price) {
}
