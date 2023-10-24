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

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    CartServiceModel cartDTOToCartServiceModel(CartDTO CartDTO);

    @Mapping(target = "id", ignore = true)
    CartRepositoryModel cartServiceModelToCartRepositoryModel(CartServiceModel cartServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    CartServiceModel cartRepositoryModelToCartServiceModel(CartRepositoryModel CartRepositoryModel);

    CartDTO cartServiceModelToCartDTO(CartServiceModel CartServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    List<CartServiceModel> listCartRepositoryModelToCartServiceModel(Iterable<CartRepositoryModel> all);

    List<CartDTO> listCartServiceModelToCartDTO(List<CartServiceModel> CartServiceModel);

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------








}
