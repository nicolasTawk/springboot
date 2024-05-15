package com.csis231.api.service;

import com.csis231.api.model.productLocation;
import com.csis231.api.repository.ProductLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLocationService {

    private final ProductLocationRepository productLocationRepository;

    @Autowired
    public ProductLocationService(ProductLocationRepository productLocationRepository) {
        this.productLocationRepository = productLocationRepository;
    }

    public productLocation addProductLocation(productLocation location) {
        return productLocationRepository.save(location);
    }

    public List<productLocation> getAllProductLocations() {
        return productLocationRepository.findAll();
    }

    public Optional<productLocation> getProductLocationById(int id) {
        return productLocationRepository.findById(id);
    }
}
