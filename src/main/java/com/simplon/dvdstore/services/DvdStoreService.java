package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DvdStoreService {

    @Autowired
    private final DvdStoreRepository dvdStoreRepository;

    public DvdStoreService(DvdStoreRepository dvdStoreRepository) {
        this.dvdStoreRepository = dvdStoreRepository;
    }

    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save(dvdRepositoryModel);
        return dvdRepositoryModelReturned != null;
    }

    public List<DvdServiceModel> findAll() {
        List<DvdRepositoryModel> dvds = dvdStoreRepository.findAll();
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for (DvdRepositoryModel dvd : dvds) {
            dvdServiceModels.add(new DvdServiceModel(dvd.getName(), dvd.getGenre()));
        }
        return dvdServiceModels;
    }

    public boolean delete(long id) {
        try {
            dvdStoreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(long id, DvdServiceModel dvdServiceModel) {
        Optional<DvdRepositoryModel> optionalDvd = dvdStoreRepository.findById(id);
        if (optionalDvd.isPresent()) {
            DvdRepositoryModel dvd = optionalDvd.get();
            dvd.setName(dvdServiceModel.getName());
            dvd.setGenre(dvdServiceModel.getGenre());
            dvdStoreRepository.save(dvd);
            return true;
        }
        return false;
    }

}
