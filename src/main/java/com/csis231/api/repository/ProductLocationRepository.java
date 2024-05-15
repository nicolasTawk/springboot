package com.csis231.api.repository;


import com.csis231.api.model.productLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLocationRepository extends JpaRepository<productLocation, Integer> {

}

