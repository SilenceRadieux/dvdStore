package com.simplon.dvdstore.repositories;

import com.simplon.dvdstore.dto.CartDvdFeignClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cart", url = "http://localhost:9090")
public interface CartFeignClientRepository {

    @GetMapping(path = "/cart-dvd")
    List<CartDvdFeignClientDto> cartDvdFindAll();

    @PostMapping(path = "/cart-dvd")
    void cartDvdAdd(CartDvdFeignClientDto cartDvdFeignClientDto);

}
