package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.dto.SaleDTO;
import com.simplon.dvdstore.services.SaleService;
import com.simplon.dvdstore.utils.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Sale controller.
 */
@RestController
@RequestMapping("sale")
public class SaleController {

    /**
     * The Sale mapper.
     */
    SaleMapper saleMapper = SaleMapper.INSTANCE;
    @Autowired
    private SaleService saleService;

    /**
     * Add sale.
     *
     * @param saleDTO the sale dto
     */
    @PostMapping
    public void addSale(@RequestBody SaleDTO saleDTO) {
        saleService.add(saleMapper.saleDTOToSaleServiceModel(saleDTO), null);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<SaleDTO> findAll() {
        return saleMapper.listSaleServiceModelToSaleDTO(saleService.findAll());
    }

    /**
     * Update sale.
     *
     * @param id      the id
     * @param SaleDTO the sale dto
     */
    @PutMapping("/{id}")
    public void updateSale(@PathVariable("id") long id, @RequestBody SaleDTO SaleDTO) {
        saleService.add(saleMapper.saleDTOToSaleServiceModel(SaleDTO), id);
    }

    /**
     * Delete sale boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteSale(@PathVariable("id") long id) {
        return saleService.delete(id);
    }

}
