package com.csis231.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "ProductExperation")
@Entity
public class ProductExpiration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expirationId;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "experationDate")
    private Date expirationDate;

    @Column(name = "quantity")
    private int quantity;

    // Default constructor
    public ProductExpiration() {}

    // Full constructor
    public ProductExpiration(Product product, Date expirationDate, int quantity) {
        this.product = product;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getExpirationId() {
        return expirationId;
    }

    public void setExpirationId(int expirationId) {
        this.expirationId = expirationId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}