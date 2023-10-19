package org.dvdstore.backpostgre.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartRepositoryModel, Long> {}
