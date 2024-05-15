package com.csis231.api.controller;

import com.csis231.api.model.productLocation;
import com.csis231.api.service.ProductLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productLocations")
public class ProductLocationController {

    private final ProductLocationService productLocationService;

    @Autowired
    public ProductLocationController(ProductLocationService productLocationService) {
        this.productLocationService = productLocationService;
    }

    @PostMapping
    public productLocation addProductLocation(@RequestBody productLocation location) {
        return productLocationService.addProductLocation(location);
    }

    @GetMapping
    public List<productLocation> getAllProductLocations() {
        return productLocationService.getAllProductLocations();
    }

    @GetMapping("/{id}")
    public Optional<productLocation> getProductLocationById(@PathVariable int id) {
        return productLocationService.getProductLocationById(id);
    }


}
