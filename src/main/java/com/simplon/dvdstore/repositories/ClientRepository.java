package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long> {

    ClientRepositoryModel save(ClientRepositoryModel clientRepositoryModel);

    List<ClientRepositoryModel> findAll();

    ClientRepositoryModel findById(long id);

}
