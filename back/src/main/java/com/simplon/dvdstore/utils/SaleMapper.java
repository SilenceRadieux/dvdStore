package com.simplon.dvdstore.utils;

import com.simplon.dvdstore.controllers.SaleDTO;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.SaleRepositoryModel;
import com.simplon.dvdstore.services.SaleServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SaleMapper {

  SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);


  SaleServiceModel saleDTOToSaleServiceModel(SaleDTO SaleDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "quantity", source = "saleServiceModel.quantity")
  @Mapping(target = "client", source = "clientRepositoryModel")
  @Mapping(target = "dvd", source = "dvdRepositoryModel")
  SaleRepositoryModel saleServiceModelToSaleRepositoryModel(SaleServiceModel saleServiceModel,
                                                             ClientRepositoryModel clientRepositoryModel,
                                                             DvdRepositoryModel dvdRepositoryModel);

  @Mapping(target = "client", source = "client.id")
  @Mapping(target = "dvd", source = "dvd.id")
  SaleServiceModel saleRepositoryModelToSaleServiceModel(SaleRepositoryModel SaleRepositoryModel);

  SaleDTO saleServiceModelToSaleDTO(SaleServiceModel SaleServiceModel);

  List<SaleServiceModel> listSaleRepositoryModelToSaleServiceModel(List<SaleRepositoryModel> SaleRepositoryModel);

  List<SaleDTO> listSaleServiceModelToSaleDTO(List<SaleServiceModel> SaleServiceModel);

}
