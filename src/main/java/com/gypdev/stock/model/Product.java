package com.gypdev.stock.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    private Inventory inventory;

    //Constructor
    public Product() {
    }

    public Product(String name, String description, Double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    //Getter&Setter

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    //Methods
    public void updateStock(int quantity){
        stock += quantity;
    }
}
