package org.dvdstore.backpostgre.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDvdRepository extends CrudRepository<CartDvdRepositoryModel, Long> {

    List<CartDvdRepositoryModel> findAllByIdCart(long id);

    @Transactional
    @Modifying
    @Query(value="CALL dvd_cart_price(:id)", nativeQuery = true)
    void total_dvd(Long id);
    @Transactional
    @Modifying
    @Query(value="CALL cart_total_price(:id)", nativeQuery = true)
    void total(Long id);
}
