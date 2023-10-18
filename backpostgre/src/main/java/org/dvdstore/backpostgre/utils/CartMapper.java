package org.dvdstore.backpostgre.utils;

import org.dvdstore.backpostgre.controllers.CartDTO;
import org.dvdstore.backpostgre.repositories.CartRepositoryModel;
import org.dvdstore.backpostgre.services.CartServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartServiceModel cartDTOToCartServiceModel(CartDTO CartDTO);

    @Mapping(target = "id", ignore = true)
    CartRepositoryModel cartServiceModelToCartRepositoryModel(CartServiceModel cartServiceModel);

    CartServiceModel cartRepositoryModelToCartServiceModel(CartRepositoryModel CartRepositoryModel);

    CartDTO cartServiceModelToCartDTO(CartServiceModel CartServiceModel);


    List<CartDTO> listCartServiceModelToCartDTO(List<CartServiceModel> CartServiceModel);

    List<CartServiceModel> listCartRepositoryModelToCartServiceModel(Iterable<CartRepositoryModel> all);
}
