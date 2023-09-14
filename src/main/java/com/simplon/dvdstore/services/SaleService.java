package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DvdStoreRepository dvdRepository;

    public boolean add(SaleServiceModel saleServiceModel) {

        DvdRepositoryModel dvd = dvdRepository.findById(saleServiceModel.getIdDvd());
        ClientRepositoryModel client = clientRepository.findById(saleServiceModel.getIdClient());
        saleRepository.save(new SaleRepositoryModel(client, dvd, saleServiceModel.getQuantity()));
        return true;
    }

}
