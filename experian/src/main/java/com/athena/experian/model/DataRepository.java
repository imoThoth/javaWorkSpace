package com.athena.experian.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends JpaRepository<DataModel, Integer> {

//    @Query("SELECT n FROM DataModel d where d.msg_id = ?1")
//    Optional<DataModel> findByMessageId(Integer msg_id);
//
//    @Query("SELECT n FROM DataModel d where d.company_name = ?1")
//    Optional<DataModel> findByCompanyName(Integer msg_id);
}
