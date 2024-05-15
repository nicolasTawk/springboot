package com.csis231.api.controller;

import com.csis231.api.model.Product;
import com.csis231.api.model.productLocation;
import com.csis231.api.service.locationMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mappings")
public class ProductLocationMappingController {

    @Autowired
    private locationMappingService service;

    @PostMapping("/allocate")
    public ResponseEntity<String> allocateProductToLocation(@RequestBody int product_ID, @RequestBody int location_ID) {
        service.allocateProductToLocation(product_ID, location_ID);
        return ResponseEntity.ok("Product allocated successfully");
    }

    @DeleteMapping("/deallocate/{id}")
    public ResponseEntity<String> deallocateProductFromLocation(@PathVariable int id) {
        service.deallocateProductFromLocation(id);
        return ResponseEntity.ok("Product deallocated successfully");
    }
}
