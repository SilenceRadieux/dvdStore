package com.simplon.dvdstore.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdServiceModel {

  private String Isan;
  private String name;
  private String genre;
  private String directedBy;
  private Integer duration;
  private String releaseDate;
  private String synopsis;
  private String cover;
  private int quantity;

}