package com.simplon.dvdstore.utils;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Dvd mapper.
 */
@Mapper
public interface DvdMapper {

    /**
     * The constant INSTANCE.
     */
    DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

    /**
     * Dvd store dto to dvd service model dvd service model.
     *
     * @param dvdStoreDTO the dvd store dto
     * @return the dvd service model
     */
    DvdServiceModel dvdStoreDTOToDvdServiceModel(DvdStoreDTO dvdStoreDTO);

    /**
     * Dvd service model to dvd repository model dvd repository model.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd repository model
     */
    DvdRepositoryModel dvdServiceModelToDvdRepositoryModel(DvdServiceModel dvdServiceModel);

    /**
     * Dvd repository model to dvd service model dvd service model.
     *
     * @param dvdRepositoryModel the dvd repository model
     * @return the dvd service model
     */
    DvdServiceModel dvdRepositoryModelToDvdServiceModel(DvdRepositoryModel dvdRepositoryModel);

    /**
     * Dvd service model to dvd store dto dvd store dto.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd store dto
     */
    DvdStoreDTO dvdServiceModelToDvdStoreDTO(DvdServiceModel dvdServiceModel);

    /**
     * List dvd repository model to dvd service model list.
     *
     * @param dvdRepositoryModel the dvd repository model
     * @return the list
     */
    List<DvdServiceModel> listDvdRepositoryModelToDvdServiceModel(List<DvdRepositoryModel> dvdRepositoryModel);

    /**
     * List dvd service model to dvd store dto list.
     *
     * @param dvdServiceModel the dvd service model
     * @return the list
     */
    List<DvdStoreDTO> listDvdServiceModelToDvdStoreDTO(List<DvdServiceModel> dvdServiceModel);

}

