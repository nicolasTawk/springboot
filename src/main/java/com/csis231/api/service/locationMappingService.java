package com.csis231.api.service;



import com.csis231.api.model.Product;
import com.csis231.api.model.productLocation;
import com.csis231.api.model.productLocationMapping;
import com.csis231.api.repository.ProductLocationRepository;
import com.csis231.api.repository.ProductRepository;
import com.csis231.api.repository.locationMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class locationMappingService {

    @Autowired
    private locationMappingRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductLocationRepository locationRepository;

    public void allocateProductToLocation(int productId, int locationId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        productLocation location = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Location not found"));

        productLocationMapping mapping = new productLocationMapping();
        mapping.setProduct(product);
        mapping.setProductLocation(location);
        repository.save(mapping);
        System.out.println("Product allocated successfully");
    }

    public void deallocateProductFromLocation(int mappingId) {
        repository.deleteById(mappingId);
        System.out.println("Product deallocated successfully");
    }
}

