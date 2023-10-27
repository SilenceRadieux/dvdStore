package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.dto.DvdStoreDTO;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import com.simplon.dvdstore.utils.DvdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dvd store controller.
 */
@RestController
@RequestMapping("dvd")
public class DvdStoreController {

    /**
     * The Dvd mapper.
     */
    DvdMapper dvdMapper = DvdMapper.INSTANCE;
    @Autowired
    private DvdStoreService dvdStoreService;

    /**
     * Add dvd.
     *
     * @param dvdStoreDTO the dvd store dto
     */
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public void addDvd(@RequestBody DvdStoreDTO dvdStoreDTO) {
        dvdStoreService.add(dvdMapper.dvdStoreDTOToDvdServiceModel(dvdStoreDTO), null);
    }

    /**
     * Add all dvds.
     *
     * @param dvdStoreDTOs the dvd store dt os
     */
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/bulk")
    public void addAllDvds(@RequestBody List<DvdStoreDTO> dvdStoreDTOs) {
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for (DvdStoreDTO dvdStoreDTO : dvdStoreDTOs) {
            DvdServiceModel dvdServiceModel =
                    dvdMapper.dvdStoreDTOToDvdServiceModel(dvdStoreDTO);
            dvdServiceModels.add(dvdServiceModel);
        }
        dvdStoreService.addAll(dvdServiceModels, null);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<DvdStoreDTO> findAll() {
        return dvdMapper.listDvdServiceModelToDvdStoreDTO(dvdStoreService.findAll());
    }

    @GetMapping("/{id}")
    public DvdStoreDTO findDvdById(@PathVariable("id") long id) {
        return dvdMapper.dvdServiceModelToDvdStoreDTO(dvdStoreService.findById(id));
    }

    /**
     * Update dvd.
     *
     * @param id          the id
     * @param dvdStoreDTO the dvd store dto
     */
/*
    @PreAuthorize("hasAuthority('admin')")
*/
    @PutMapping("/{id}")
    public void updateDvd(@PathVariable("id") long id, @RequestBody DvdStoreDTO dvdStoreDTO) {
        dvdStoreService.add(dvdMapper.dvdStoreDTOToDvdServiceModel(dvdStoreDTO), id);
    }

    /**
     * Delete dvd boolean.
     *
     * @param id the id
     * @return the boolean
     */
/*
    @PreAuthorize("hasAuthority('admin')")
*/
    @DeleteMapping("/{id}")
    public boolean deleteDvd(@PathVariable("id") long id) {
        return dvdStoreService.delete(id);
    }

}
