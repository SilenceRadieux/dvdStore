package org.dvdstore.backpostgre.services;

import jakarta.annotation.Nullable;
import org.dvdstore.backpostgre.repositories.CartRepository;
import org.dvdstore.backpostgre.repositories.CartRepositoryModel;
import org.dvdstore.backpostgre.utils.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    CartMapper cartMapper = CartMapper.INSTANCE;

    public void add(CartServiceModel cartServiceModel, @Nullable Long id) {
        CartRepositoryModel cartRepositoryModel = cartMapper.cartServiceModelToCartRepositoryModel(cartServiceModel);
        cartRepository.save(cartRepositoryModel);
    }

    public CartServiceModel findById(long id) {
        return cartMapper.cartRepositoryModelToCartServiceModel(cartRepository.findById(id).orElse(null));
    }

    public List<CartServiceModel> findAll() {
        return cartMapper.listCartRepositoryModelToCartServiceModel(cartRepository.findAll());
    }

    public boolean delete(long id) {
        try {
            cartRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
