package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel, Long> {

    DvdRepositoryModel findById(long id);
    DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);

    List<DvdRepositoryModel> findAll();

//    DvdRepositoryModel deleteById(long id);
//
//    DvdRepositoryModel update(long id, DvdRepositoryModel dvdRepositoryModel);


}
