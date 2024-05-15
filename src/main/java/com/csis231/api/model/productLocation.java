package com.csis231.api.model;

import jakarta.persistence.*;

@Table(name = "productLocation")
@Entity
public class productLocation {

    @Column(name = "productLocation_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productLocation_id;

    @Column(name = "Aile")
    private String Aile;

    @Column(name = "shelf")
    private String shelf;

    @Column(name = "bin")
    private String bin;

    public productLocation(String aile, String shelf, String bin) {
        Aile = aile;
        this.shelf = shelf;
        this.bin = bin;
    }

    public productLocation() {}

    public int getProductLocation_id() {
        return productLocation_id;
    }

    public void setProductLocation_id(int productLocation_id) {
        this.productLocation_id = productLocation_id;
    }

    public String getAile() {
        return Aile;
    }

    public void setAile(String aile) {
        Aile = aile;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }
}
