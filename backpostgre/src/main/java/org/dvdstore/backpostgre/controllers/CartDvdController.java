package org.dvdstore.backpostgre.controllers;

import org.dvdstore.backpostgre.services.CartDvdService;
import org.dvdstore.backpostgre.utils.CartDvdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dvd_cart")
public class CartDvdController {

    CartDvdMapper cartDvdMapper = CartDvdMapper.INSTANCE;

    @Autowired
    private CartDvdService cartDvdService;

    @PostMapping
    public void addCartDvd(@RequestBody CartDvdDTO cartDvdDTO) {
        cartDvdService.add(cartDvdMapper.cartDvdDTOTocartDvdServiceModel(cartDvdDTO));
    }

    @GetMapping("/{id}")
    public List<CartDvdDTO> findAllByCartId(@PathVariable("id") long id) {
        return cartDvdMapper.listCartDvdServiceModelToCartDvdDTO(
            cartDvdService.findAllByCartId(id)
        );
    }

    @PutMapping("/{id}")
    public void updateCartDvd(@PathVariable("id") long id, @RequestBody CartDvdDTO CartDvdDTO) {
        cartDvdService.add(cartDvdMapper.cartDvdDTOToCartDvdServiceModel(CartDvdDTO));
    }

    @DeleteMapping("/{id}")
    public boolean deleteCartDvd(@PathVariable("id") long id){return cartDvdService.delete(id);}

}