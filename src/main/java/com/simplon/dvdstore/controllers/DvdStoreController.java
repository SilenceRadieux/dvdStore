package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dvdstore")
public class DvdStoreController {

    @Autowired
    private final DvdStoreService dvdStoreService;

    public DvdStoreController(DvdStoreService dvdStoreService) {
        this.dvdStoreService = dvdStoreService;
    }

}
