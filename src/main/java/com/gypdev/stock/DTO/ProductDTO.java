package com.gypdev.stock.DTO;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.model.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;
    private Inventory inventory;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
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

    public Inventory getInventory() {
        return inventory;
    }
}
