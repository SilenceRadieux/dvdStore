package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import com.simplon.dvdstore.utils.SaleMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

  @Autowired
  SaleRepository saleRepository;
  @Autowired
  ClientRepository clientRepository;
  @Autowired
  DvdStoreRepository dvdRepository;

  SaleMapper saleMapper = SaleMapper.INSTANCE;

  public void add(SaleServiceModel saleServiceModel, @Nullable Long id) {
    SaleRepositoryModel saleRepositoryModel = saleMapper.saleServiceModelToSaleRepositoryModel(saleServiceModel,
      clientRepository.findById(saleServiceModel.getClient()).get(),
      dvdRepository.findById(saleServiceModel.getDvd()).get()
    );
    if (id != null) {
      saleRepositoryModel.setId(id);
    }
    DvdRepositoryModel dvdRepositoryModel = saleRepositoryModel.getDvd();
    int quantity = dvdRepositoryModel.getQuantity() - saleServiceModel.getQuantity();
    dvdRepositoryModel.setQuantity(quantity);
    saleRepository.save(saleRepositoryModel);
  }

  public List<SaleServiceModel> findAll() {
    return saleMapper.listSaleRepositoryModelToSaleServiceModel(saleRepository.findAll());
  }

  public boolean delete(long id) {
    try {
      saleRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
