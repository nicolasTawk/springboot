package com.csis231.api.repository;

import com.csis231.api.model.productLocationMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface locationMappingRepository extends JpaRepository<productLocationMapping, Integer> {

}
