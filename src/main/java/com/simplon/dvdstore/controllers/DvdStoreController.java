package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("dvd")
public class DvdStoreController {

//    private DvdMapper dvdMapper;

    @Autowired
    private DvdStoreService dvdStoreService;

//    @Autowired
//    public DvdStoreController(DvdMapper dvdMapper, DvdStoreRepository dvdStoreRepository){
//        this.dvdMapper = dvdMapper;
//        this.dvdStoreRepository = dvdStoreRepository;
//    }

    @PostMapping
    public boolean addDvd(@RequestBody DvdStoreDTO dvdStoreDTO){
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.name(), dvdStoreDTO.genre(), dvdStoreDTO.quantity());
        return dvdStoreService.add(dvdServiceModel);
    }

    @GetMapping
    public List<DvdStoreDTO> findAll() {
        List<DvdServiceModel> dvds = dvdStoreService.findAll();
        List<DvdStoreDTO> dvdStoreDTOs = new ArrayList<>();
        for (DvdServiceModel dvd : dvds) {
            dvdStoreDTOs.add(new DvdStoreDTO(dvd.getName(), dvd.getGenre(), dvd.getQuantity()));
        }
        return dvdStoreDTOs;
    }

    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable("id") long id, @RequestBody DvdStoreDTO dvdStoreDTO){
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.name(), dvdStoreDTO.genre(), dvdStoreDTO.quantity());
        return dvdStoreService.update(id, dvdServiceModel);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDvd(@PathVariable("id") long id){
        return dvdStoreService.delete(id);
    }

}
