package org.dvdstore.backpostgre.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<CartRepositoryModel, Long> {

    List<CartRepositoryModel> findAllById(Long id);



}
