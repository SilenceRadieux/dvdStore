package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import com.simplon.dvdstore.utils.DvdMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdStoreService {

  @Autowired
  private DvdStoreRepository dvdStoreRepository;

  DvdMapper dvdMapper = DvdMapper.INSTANCE;

  public void add(DvdServiceModel dvdServiceModel, @Nullable Long id) {
    DvdRepositoryModel dvdRepositoryModel = dvdMapper.dvdServiceModelToDvdRepositoryModel(dvdServiceModel);
    if (id != null) {
      dvdRepositoryModel.setId(id);
    }
    dvdStoreRepository.save(dvdRepositoryModel);
  }

  public void addAll(List<DvdServiceModel> dvdServiceModels, @Nullable List<Long> ids) {
    for (int i = 0; i < dvdServiceModels.size(); i++) {
      DvdServiceModel dvdServiceModel = dvdServiceModels.get(i);
      DvdRepositoryModel dvdRepositoryModel = dvdMapper.dvdServiceModelToDvdRepositoryModel(dvdServiceModel);
      if (ids != null && i < ids.size()) {
        Long id = ids.get(i);
        dvdRepositoryModel.setId(id);
      }
      dvdStoreRepository.save(dvdRepositoryModel);
    }
  }

  public List<DvdServiceModel> findAll() {
    return dvdMapper.listDvdRepositoryModelToDvdServiceModel((List<DvdRepositoryModel>)
      dvdStoreRepository.findAll());
  }

  public boolean delete(long id) {
    try {
      dvdStoreRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
