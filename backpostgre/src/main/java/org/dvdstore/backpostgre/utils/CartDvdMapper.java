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

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    CartDvdServiceModel cartDvdDTOTocartDvdServiceModel(CartDvdDTO cartDvdDTO);

    @Mapping(target = "idCart")
    CartDvdRepositoryModel cartDvdServiceModelToCartDvdRepositoryModel(
            CartDvdServiceModel cartDvdServiceModel, CartRepositoryModel cartRepositoryModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    CartServiceModel cartDvdRepositoryModelToCartDvdServiceModel(CartDvdRepositoryModel cartDvdRepositoryModel);

    CartDvdDTO cartDvdServiceModelToCartDvdDTO(CartDvdServiceModel cartDvdServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------




    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------


}
