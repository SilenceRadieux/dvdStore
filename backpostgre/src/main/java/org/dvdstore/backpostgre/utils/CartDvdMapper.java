package org.dvdstore.backpostgre.utils;

import org.dvdstore.backpostgre.controllers.CartDvdDTO;
import org.dvdstore.backpostgre.repositories.CartDvdRepositoryModel;
import org.dvdstore.backpostgre.services.CartDvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartDvdMapper {

    CartDvdMapper INSTANCE = Mappers.getMapper(CartDvdMapper.class);

    CartDvdServiceModel cartDvdDTOToCartDvdServiceModel(CartDvdDTO CartDvdDTO);

    CartDvdRepositoryModel cartDvdServiceModelToCartDvdRepositoryModel(CartDvdServiceModel cartDvdServiceModel);

    CartDvdServiceModel cartDvdDTOTocartDvdServiceModel(CartDvdDTO cartDvdDTO);

    List<CartDvdServiceModel> listCartDvdRepositoryModelToCartDvdServiceModel(List<CartDvdRepositoryModel> CartDvdRepositoryModel);

    List<CartDvdDTO> listCartDvdServiceModelToCartDvdDTO(List<CartDvdServiceModel> CartDvdServiceModel);


}
