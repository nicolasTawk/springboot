package com.csis231.api.model;

import jakarta.persistence.*;
import com.csis231.api.model.Product;
import com.csis231.api.model.productLocation;

@Table(name = "productLocationMapping")
@Entity
public class productLocationMapping {

    @Column(name = "mapping_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mapping_id;

    @OneToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @OneToOne
    @JoinColumn(name = "productLocation_id")
    private productLocation productLocation;

    public int getMapping_id() {
        return mapping_id;
    }

    public void setMapping_id(int mapping_id) {
        this.mapping_id = mapping_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public com.csis231.api.model.productLocation getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(com.csis231.api.model.productLocation productLocation) {
        this.productLocation = productLocation;
    }
}
