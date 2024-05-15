package com.csis231.api.repository;


 import com.csis231.api.model.batches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface batchesRepository extends JpaRepository<batches, Integer> {

    @Query(value = "SELECT * FROM batches WHERE expiration_date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 1 MONTH)", nativeQuery = true)
    List<batches> findBatchesExpiringWithinOneMonth();
    @Query("SELECT b FROM batches b WHERE b.experation_date < CURRENT_DATE")
    List<batches> findExpiredBatches();

}

