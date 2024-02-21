package com.gypdev.stock.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private int stock;
    private String pathImage;


    //Constructor
    public Product() {
    }

    public Product(String code,String name, String description, Double price, int stock, String pathImage) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.pathImage = pathImage;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    //Methods
    public void updateStock(int quantity){
        stock += quantity;
    }


}
