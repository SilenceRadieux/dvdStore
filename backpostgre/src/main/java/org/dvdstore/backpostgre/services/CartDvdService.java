package org.dvdstore.backpostgre.services;

import org.dvdstore.backpostgre.repositories.CartDvdRepository;
import org.dvdstore.backpostgre.repositories.CartDvdRepositoryModel;
import org.dvdstore.backpostgre.repositories.CartRepository;
import org.dvdstore.backpostgre.utils.CartDvdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDvdService {

    @Autowired
    CartDvdRepository cartDvdRepository;

    @Autowired
    CartRepository cartRepository;

    CartDvdMapper cartDvdMapper = CartDvdMapper.INSTANCE;

    public void add(CartDvdServiceModel cartDvdServiceModel) {
        CartDvdRepositoryModel cartDvdRepositoryModel =cartDvdMapper.cartDvdServiceModelToCartDvdRepositoryModel(
                cartDvdServiceModel, cartRepository.findById(cartDvdServiceModel.getId_cart()).get());
        cartDvdRepository.save(cartDvdRepositoryModel);
        cartDvdRepository.total_dvd(cartDvdRepositoryModel.getId());
        cartDvdRepository.total(cartDvdRepositoryModel.getId_cart().getId());
    }

    public CartDvdServiceModel findAllByCartId(long id) {
        return cartDvdMapper.cartDvdRepositoryModelToCartDvdServiceModel();
    }

    public boolean delete(long id) {
        try {
            cartDvdRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
