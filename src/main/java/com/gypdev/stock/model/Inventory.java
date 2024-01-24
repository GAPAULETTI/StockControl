package com.gypdev.stock.model;

import jakarta.persistence.Entity;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Inventory {

    private Map<String, Product> productMap;

    public  Inventory(){
        productMap = new HashMap<>();
    }

    public void addProduct(String name,String description, Double price, int stock){
        Product product = new Product(name, description, price, stock);
        productMap.put(name, product);
    }
}
