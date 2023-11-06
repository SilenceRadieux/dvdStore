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

/**
 * The interface Sale mapper.
 */
@Mapper
public interface SaleMapper {

    /**
     * The constant INSTANCE.
     */
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);


    /**
     * Sale dto to sale service model sale service model.
     *
     * @param SaleDTO the sale dto
     * @return the sale service model
     */
    SaleServiceModel saleDTOToSaleServiceModel(SaleDTO SaleDTO);

    /**
     * Sale service model to sale repository model sale repository model.
     *
     * @param saleServiceModel      the sale service model
     * @param clientRepositoryModel the client repository model
     * @param dvdRepositoryModel    the dvd repository model
     * @return the sale repository model
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "quantity", source = "saleServiceModel.quantity")
    @Mapping(target = "client", source = "clientRepositoryModel")
    @Mapping(target = "dvd", source = "dvdRepositoryModel")
    SaleRepositoryModel saleServiceModelToSaleRepositoryModel(SaleServiceModel saleServiceModel,
                                                              ClientRepositoryModel clientRepositoryModel,
                                                              DvdRepositoryModel dvdRepositoryModel);

    /**
     * Sale repository model to sale service model sale service model.
     *
     * @param SaleRepositoryModel the sale repository model
     * @return the sale service model
     */
    @Mapping(target = "client", source = "client.id")
    @Mapping(target = "dvd", source = "dvd.id")
    SaleServiceModel saleRepositoryModelToSaleServiceModel(SaleRepositoryModel SaleRepositoryModel);

    /**
     * Sale service model to sale dto sale dto.
     *
     * @param SaleServiceModel the sale service model
     * @return the sale dto
     */
    SaleDTO saleServiceModelToSaleDTO(SaleServiceModel SaleServiceModel);

    /**
     * List sale repository model to sale service model list.
     *
     * @param SaleRepositoryModel the sale repository model
     * @return the list
     */
    List<SaleServiceModel> listSaleRepositoryModelToSaleServiceModel(List<SaleRepositoryModel> SaleRepositoryModel);

    /**
     * List sale service model to sale dto list.
     *
     * @param SaleServiceModel the sale service model
     * @return the list
     */
    List<SaleDTO> listSaleServiceModelToSaleDTO(List<SaleServiceModel> SaleServiceModel);

}
