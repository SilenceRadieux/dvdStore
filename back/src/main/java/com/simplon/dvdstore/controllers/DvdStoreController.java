package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import com.simplon.dvdstore.utils.DvdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("dvd")
public class DvdStoreController {

  @Autowired
  private DvdStoreService dvdStoreService;

  DvdMapper dvdMapper = DvdMapper.INSTANCE;

  @PostMapping
  public void addDvd(@RequestBody DvdStoreDTO dvdStoreDTO) {
    dvdStoreService.add(dvdMapper.dvdStoreDTOToDvdServiceModel(dvdStoreDTO), null);
  }

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

  @GetMapping
  public List<DvdStoreDTO> findAll() {
    return dvdMapper.listDvdServiceModelToDvdStoreDTO(dvdStoreService.findAll());
  }

  @PutMapping("/{id}")
  public void updateDvd(@PathVariable("id") long id, @RequestBody DvdStoreDTO dvdStoreDTO) {
    dvdStoreService.add(dvdMapper.dvdStoreDTOToDvdServiceModel(dvdStoreDTO), id);
  }

  @DeleteMapping("/{id}")
  public boolean deleteDvd(@PathVariable("id") long id) {
    return dvdStoreService.delete(id);
  }

}
