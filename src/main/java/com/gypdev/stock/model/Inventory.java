package com.gypdev.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

    private Map<String, Product> productMap;

    public  Inventory(){
        productMap = new HashMap<>();
    }



    public void addProduct(String name, String description, Double price, int stock){
        Product product = new Product(name, description, price, stock);
        productMap.put(name, product);
    }
    public void updateStock(String productName, int quantity){
        Product product = productMap.get(productName);
        if (product != null){
            product.updateStock(quantity);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }
}
