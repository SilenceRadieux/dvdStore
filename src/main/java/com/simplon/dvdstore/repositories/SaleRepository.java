package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<SaleRepositoryModel, Long> {

    SaleRepositoryModel save(SaleRepositoryModel saleRepositoryModel);

    List<SaleRepositoryModel> findAll();

}
