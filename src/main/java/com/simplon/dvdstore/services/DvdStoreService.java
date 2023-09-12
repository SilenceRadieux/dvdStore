package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreService {

    @Autowired
    private final DvdStoreRepository dvdStoreRepository;

    public DvdStoreService(DvdStoreRepository dvdStoreRepository) {
        this.dvdStoreRepository = dvdStoreRepository;
    }

}
