package com.gypdev.stock.DTO;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.model.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.awt.*;

public class ProductDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private int stock;
    private String pathImage;


    public ProductDTO(Product product){
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.pathImage = product.getPathImage();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCode() {
        return code;
    }

    public String getPathImage() {
        return pathImage;
    }
}
