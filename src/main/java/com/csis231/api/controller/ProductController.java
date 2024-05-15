package com.csis231.api.controller;

import com.csis231.api.model.Product;
import com.csis231.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Map<String, String> requestBody) {
        String productName = requestBody.get("productName");
        String productDescription = requestBody.get("productDescription");
        double productPrice = Double.parseDouble(requestBody.get("productPrice"));

        Product product = new Product(productName, productDescription, productPrice);

        Product savedProduct = productService.addProduct(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping("/{productId}/buy")
    public ResponseEntity<?> buyProduct(@PathVariable int productId,
                                        @RequestParam int quantity,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date expirationDate) {
        productService.buyProduct(productId, quantity, expirationDate);
        return ResponseEntity.ok("Product purchased successfully.");
    }

    @PostMapping("/{productId}/sell")
    public ResponseEntity<?> sellProduct(@PathVariable int productId, @RequestParam int quantity) {
        productService.sellProduct(productId, quantity);
        return ResponseEntity.ok("Product sold successfully.");
    }
}