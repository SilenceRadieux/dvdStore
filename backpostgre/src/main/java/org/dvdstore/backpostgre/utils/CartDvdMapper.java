package org.dvdstore.backpostgre.utils;

import org.dvdstore.backpostgre.controllers.CartDvdDTO;
import org.dvdstore.backpostgre.repositories.CartDvdRepositoryModel;
import org.dvdstore.backpostgre.repositories.CartRepositoryModel;
import org.dvdstore.backpostgre.services.CartDvdServiceModel;
import org.dvdstore.backpostgre.services.CartServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartDvdMapper {

    CartDvdMapper INSTANCE = Mappers.getMapper(CartDvdMapper.class);

    CartDvdDTO cartDvdServiceModelToCartDvdDTO(CartDvdServiceModel cartDvdServiceModel);

    CartServiceModel cartDvdRepositoryModelToCartDvdServiceModel(CartDvdRepositoryModel cartDvdRepositoryModel);

    @Mapping(target = "id_cart", source = "cartRepositoryModel")
    CartDvdRepositoryModel cartDvdServiceModelToCartDvdRepositoryModel(
            CartDvdServiceModel cartDvdServiceModel, CartRepositoryModel cartRepositoryModel);

    CartDvdServiceModel cartDvdDTOTocartDvdServiceModel(CartDvdDTO cartDvdDTO);




}
