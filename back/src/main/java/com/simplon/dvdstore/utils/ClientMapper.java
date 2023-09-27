package com.simplon.dvdstore.utils;


import com.simplon.dvdstore.controllers.ClientDTO;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  ClientServiceModel clientDTOToClientServiceModel(ClientDTO clientDTO);

  ClientRepositoryModel clientServiceModelToClientRepositoryModel(ClientServiceModel clientServiceModel);

  ClientServiceModel clientRepositoryModelToClientServiceModel(ClientRepositoryModel clientRepositoryModel);

  ClientDTO clientServiceModelToClientDTO(ClientServiceModel clientServiceModel);

  List<ClientServiceModel> listClientRepositoryModelToClientServicieModel(List<ClientRepositoryModel> clientRepositoryModel);

  List<ClientDTO> listClientServiceModelToClientDTO(List<ClientServiceModel> clientServiceModel);

}
