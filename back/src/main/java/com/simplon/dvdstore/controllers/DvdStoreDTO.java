package com.simplon.dvdstore.controllers;

public record DvdStoreDTO(
  String isan,
  String name,
  String genre,
  String directedBy,
  int duration,
  String releaseDate,
  String synopsis,
  String cover,
  int quantity
) {
}
