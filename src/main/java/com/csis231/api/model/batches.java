package com.csis231.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "batches")
public class batches {

    @Column(name = "batch_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batch_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "experation_date")
    private Date experation_date;

    @Column(name = "quantity")
    private int quantity;
    public batches(Product product, Date experation_date, int quantity) {
        this.product = product;
        this.experation_date = experation_date;
        this.quantity = quantity;
    }

    public batches() {
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getExperation_date() {
        return experation_date;
    }

    public void setExperation_date(Date experation_date) {
        this.experation_date = experation_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
