package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.dto.CartDvdFeignClientDto;
import com.simplon.dvdstore.services.CartFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
@CrossOrigin(origins = "http://localhost:90", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class CartFeignClientController {

    @Autowired
    CartFeignClientService cartFeignClientService;

    @GetMapping(path = "/")
    public List<CartDvdFeignClientDto> cartDvdFindAll() {
        return cartFeignClientService.cartDvdFindAll();
    }

    @PostMapping(path = "/")
    public void cartDvdAdd(@RequestBody CartDvdFeignClientDto cartDvdFeignClientDto) {
        cartFeignClientService.cartDvdAdd(cartDvdFeignClientDto);
    }

}
