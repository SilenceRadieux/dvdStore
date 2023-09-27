package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.ClientRepository;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.utils.ClientMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  ClientMapper clientMapper = ClientMapper.INSTANCE;

  public void add(com.simplon.dvdstore.services.ClientServiceModel clientServiceModel, @Nullable Long id) {
    ClientRepositoryModel clientRepositoryModel = clientMapper.clientServiceModelToClientRepositoryModel(clientServiceModel);
    if (id != null) {
      clientRepositoryModel.setId(id);
    }
    clientRepository.save(clientRepositoryModel);
  }

  public void addAll(List<com.simplon.dvdstore.services.ClientServiceModel> clientServiceModels, @Nullable List<Long> ids) {
    for (int i = 0; i < clientServiceModels.size(); i++) {
      com.simplon.dvdstore.services.ClientServiceModel clientServiceModel = clientServiceModels.get(i);
      ClientRepositoryModel clientRepositoryModel = clientMapper.clientServiceModelToClientRepositoryModel(clientServiceModel);
      if (ids != null && i < ids.size()) {
        Long id = ids.get(i);
        clientRepositoryModel.setId(id);
      }
      clientRepository.save(clientRepositoryModel);
    }
  }

  public List<com.simplon.dvdstore.services.ClientServiceModel> findAll() {
    return clientMapper.listClientRepositoryModelToClientServicieModel((List<ClientRepositoryModel>)
      clientRepository.findAll());
  }

  public boolean delete(long id) {
    try {
      clientRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
