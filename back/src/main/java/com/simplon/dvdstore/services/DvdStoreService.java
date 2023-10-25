package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import com.simplon.dvdstore.utils.DvdMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Dvd store service.
 */
@Service
public class DvdStoreService {

    /**
     * The Dvd mapper.
     */
    DvdMapper dvdMapper = DvdMapper.INSTANCE;
    @Autowired
    private DvdStoreRepository dvdStoreRepository;

    /**
     * Add.
     *
     * @param dvdServiceModel the dvd service model
     * @param id              the id
     */
    public void add(DvdServiceModel dvdServiceModel, @Nullable Long id) {
        DvdRepositoryModel dvdRepositoryModel = dvdMapper.dvdServiceModelToDvdRepositoryModel(dvdServiceModel);
        if (id != null) {
            dvdRepositoryModel.setId(id);
        }
        dvdStoreRepository.save(dvdRepositoryModel);
    }

    /**
     * Add all.
     *
     * @param dvdServiceModels the dvd service models
     * @param ids              the ids
     */
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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<DvdServiceModel> findAll() {
        return dvdMapper.listDvdRepositoryModelToDvdServiceModel((List<DvdRepositoryModel>)
                dvdStoreRepository.findAll());
    }

    public DvdServiceModel findById(Long id) {
        Optional<DvdRepositoryModel> dvdOptional = dvdStoreRepository.findById(id);
        return dvdOptional.map(dvdRepositoryModel ->
                dvdMapper.dvdRepositoryModelToDvdServiceModel(dvdRepositoryModel)).orElse(null);
    }


    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean delete(long id) {
        try {
            dvdStoreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
