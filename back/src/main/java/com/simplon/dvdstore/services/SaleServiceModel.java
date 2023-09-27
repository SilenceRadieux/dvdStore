package com.simplon.dvdstore.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleServiceModel {

  private long client;
  private long dvd;
  private int quantity;

}
