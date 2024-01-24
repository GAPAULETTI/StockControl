package com.gypdev.stock.model;


public class Product {

    private int id;
    private String name;
    private String description;
    private Double price;

    //Constructor
    public Product() {
    }

    //Getter&Setter

    public int getId() {
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
    //Methods

}
