package com.simplon.dvdstore.services;

import com.simplon.dvdstore.dto.CartDvdFeignClientDto;
import com.simplon.dvdstore.repositories.CartFeignClientRepository;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartFeignClientService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;

    private final CartFeignClientRepository cartFeignClientRepository;

    public CartFeignClientService(CartFeignClientRepository cartFeignClientRepository) {
        this.cartFeignClientRepository = cartFeignClientRepository;
    }

    public List<CartDvdFeignClientDto> cartDvdFindAll(){
        return cartFeignClientRepository.cartDvdFindAll();
    }

    public void cartDvdAdd(CartDvdFeignClientDto cartDvdFeignClientDto){
        cartFeignClientRepository.cartDvdAdd(cartDvdFeignClientDto);
    }


}
