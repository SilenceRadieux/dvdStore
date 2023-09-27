package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.SaleService;
import com.simplon.dvdstore.utils.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleController {

  @Autowired
  private SaleService saleService;

  SaleMapper saleMapper = SaleMapper.INSTANCE;

  @PostMapping
  public void addSale(@RequestBody SaleDTO saleDTO) {
    saleService.add(saleMapper.saleDTOToSaleServiceModel(saleDTO), null);
  }

  @GetMapping
  public List<SaleDTO> findAll() {
    return saleMapper.listSaleServiceModelToSaleDTO(saleService.findAll());
  }

  @PutMapping("/{id}")
  public void updateSale(@PathVariable("id") long id, @RequestBody SaleDTO SaleDTO) {
    saleService.add(saleMapper.saleDTOToSaleServiceModel(SaleDTO), id);
  }

  @DeleteMapping("/{id}")
  public boolean deleteSale(@PathVariable("id") long id) {
    return saleService.delete(id);
  }

}
