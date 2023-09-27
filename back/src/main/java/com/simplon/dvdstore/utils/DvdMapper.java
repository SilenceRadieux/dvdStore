package com.simplon.dvdstore.utils;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdMapper {

  DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

  DvdServiceModel dvdStoreDTOToDvdServiceModel(DvdStoreDTO dvdStoreDTO);

  DvdRepositoryModel dvdServiceModelToDvdRepositoryModel(DvdServiceModel dvdServiceModel);

  DvdServiceModel dvdRepositoryModelToDvdServiceModel(DvdRepositoryModel dvdRepositoryModel);

  DvdStoreDTO dvdServiceModelToDvdStoreDTO(DvdServiceModel dvdServiceModel);

  List<DvdServiceModel> listDvdRepositoryModelToDvdServiceModel(List<DvdRepositoryModel> dvdRepositoryModel);

  List<DvdStoreDTO> listDvdServiceModelToDvdStoreDTO(List<DvdServiceModel> dvdServiceModel);

}

