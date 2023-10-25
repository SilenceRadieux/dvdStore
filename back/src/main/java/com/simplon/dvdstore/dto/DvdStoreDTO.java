package com.simplon.dvdstore.dto;

/**
 * The type Dvd store dto.
 */
public record DvdStoreDTO(
        Long id,
        String isan,
        String name,
        String genre,
        String directedBy,
        int duration,
        String releaseDate,
        String synopsis,
        String cover,
        int quantity,
        Float price
) {
}
