package com.simplon.dvdstore.utils;


import com.simplon.dvdstore.controllers.ClientDTO;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Client mapper.
 */
@Mapper
public interface ClientMapper {

    /**
     * The constant INSTANCE.
     */
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    /**
     * Client dto to client service model client service model.
     *
     * @param clientDTO the client dto
     * @return the client service model
     */
    ClientServiceModel clientDTOToClientServiceModel(ClientDTO clientDTO);

    /**
     * Client service model to client repository model client repository model.
     *
     * @param clientServiceModel the client service model
     * @return the client repository model
     */
    ClientRepositoryModel clientServiceModelToClientRepositoryModel(ClientServiceModel clientServiceModel);

    /**
     * Client repository model to client service model client service model.
     *
     * @param clientRepositoryModel the client repository model
     * @return the client service model
     */
    ClientServiceModel clientRepositoryModelToClientServiceModel(ClientRepositoryModel clientRepositoryModel);

    /**
     * Client service model to client dto client dto.
     *
     * @param clientServiceModel the client service model
     * @return the client dto
     */
    ClientDTO clientServiceModelToClientDTO(ClientServiceModel clientServiceModel);

    /**
     * List client repository model to client servicie model list.
     *
     * @param clientRepositoryModel the client repository model
     * @return the list
     */
    List<ClientServiceModel> listClientRepositoryModelToClientServicieModel(List<ClientRepositoryModel> clientRepositoryModel);

    /**
     * List client service model to client dto list.
     *
     * @param clientServiceModel the client service model
     * @return the list
     */
    List<ClientDTO> listClientServiceModelToClientDTO(List<ClientServiceModel> clientServiceModel);

}
