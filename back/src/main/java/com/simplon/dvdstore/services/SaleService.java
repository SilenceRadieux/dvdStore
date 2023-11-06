package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import com.simplon.dvdstore.utils.SaleMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Sale service.
 */
@Service
public class SaleService {

    /**
     * The Sale repository.
     */
    @Autowired
    SaleRepository saleRepository;
    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;
    /**
     * The Dvd repository.
     */
    @Autowired
    DvdStoreRepository dvdRepository;

    /**
     * The Sale mapper.
     */
    SaleMapper saleMapper = SaleMapper.INSTANCE;

    /**
     * Add.
     *
     * @param saleServiceModel the sale service model
     * @param id               the id
     */
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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<SaleServiceModel> findAll() {
        return saleMapper.listSaleRepositoryModelToSaleServiceModel(saleRepository.findAll());
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean delete(long id) {
        try {
            saleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
