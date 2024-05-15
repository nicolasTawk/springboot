package com.csis231.api.service;

import com.csis231.api.model.Product;
import com.csis231.api.model.ProductExpiration;
import com.csis231.api.repository.ProductRepository;
import com.csis231.api.repository.ProductExpirationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductExpirationRepository productExpirationRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductExpirationRepository productExpirationRepository) {
        this.productRepository = productRepository;
        this.productExpirationRepository = productExpirationRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
@Transactional
    public Product addProduct(Product product) {return productRepository.save(product);}


@Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProducts(){return productRepository.findAll();}



    @Transactional
    public void buyProduct(int productId, int quantity, Date expirationDate) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        ProductExpiration newExpiration = new ProductExpiration(product, expirationDate, quantity);
        productExpirationRepository.save(newExpiration);

        product.setQuantityInStock(product.getQuantityInStock() + quantity);
        productRepository.save(product);
    }

    @Transactional
    public void sellProduct(int productId, int quantityToSell) {
        List<ProductExpiration> expirations = productExpirationRepository
                .findAvailableByProductIdOrderByDateAsc(productId);

        for (ProductExpiration expiration : expirations) {
            if (quantityToSell <= 0) break;
            int quantityToDeduct = Math.min(expiration.getQuantity(), quantityToSell);
            expiration.setQuantity(expiration.getQuantity() - quantityToDeduct);
            productExpirationRepository.save(expiration);
            quantityToSell -= quantityToDeduct;

            if (expiration.getQuantity() == 0) {
                productExpirationRepository.delete(expiration);
            }
        }

        if (quantityToSell > 0) {
            throw new RuntimeException("Insufficient stock");
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        product.setQuantityInStock(product.getQuantityInStock() - quantityToSell);
        productRepository.save(product);
    }
}