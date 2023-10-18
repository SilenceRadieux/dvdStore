package org.dvdstore.backpostgre.controllers;

import org.dvdstore.backpostgre.services.CartService;
import org.dvdstore.backpostgre.utils.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    CartMapper cartMapper = CartMapper.INSTANCE;

    @Autowired
    private CartService cartService;

    @PostMapping
    public void addCart(@RequestBody CartDTO cartDTO) {
        cartService.add(cartMapper.cartDTOToCartServiceModel(cartDTO), null);
    }

    @GetMapping("/{id}")
    public List<CartDTO> findAll() {return cartMapper.listCartServiceModelToCartDTO(cartService.findAll());}

    @PutMapping("/{id}")
    public void updateCart(@PathVariable("id") long id, @RequestBody CartDTO CartDTO) {
        cartService.add(cartMapper.cartDTOToCartServiceModel(CartDTO), id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCart(@PathVariable("id") long id){return cartService.delete(id);}

}
