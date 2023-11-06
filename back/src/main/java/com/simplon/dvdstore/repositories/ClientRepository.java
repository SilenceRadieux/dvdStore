package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Client repository.
 */
@Repository
public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long> {

}
