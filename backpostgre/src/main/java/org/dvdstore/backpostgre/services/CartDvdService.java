package org.dvdstore.backpostgre.services;

import org.dvdstore.backpostgre.repositories.CartDvdRepository;
import org.dvdstore.backpostgre.repositories.CartDvdRepositoryModel;
import org.dvdstore.backpostgre.utils.CartDvdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDvdService {

    @Autowired
    CartDvdRepository cartDvdRepository;


    CartDvdMapper cartDvdMapper = CartDvdMapper.INSTANCE;

    public void add(CartDvdServiceModel cartDvdServiceModel) {
        CartDvdRepositoryModel cartDvdRepositoryModel =cartDvdMapper.cartDvdServiceModelToCartDvdRepositoryModel(cartDvdServiceModel);
        cartDvdRepository.save(cartDvdRepositoryModel);
        cartDvdRepository.total_dvd(cartDvdRepositoryModel.getId());
        cartDvdRepository.total(cartDvdRepositoryModel.getCart().getId());
    }

    public List<CartDvdServiceModel> findAllByCartId(long id) {
        return cartDvdMapper.listCartDvdRepositoryModelToCartDvdServiceModel(cartDvdRepository.findAllByCartId(id));
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
