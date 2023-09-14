package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.SaleService;
import com.simplon.dvdstore.services.SaleServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public boolean addSale(@RequestBody SaleDTO saleDTO){
        SaleServiceModel saleServiceModel =  new SaleServiceModel(saleDTO.idClient(), saleDTO.idDvd(), saleDTO.quantity());
        return saleService.add(saleServiceModel);
    }

}
