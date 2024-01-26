package com.gypdev.stock.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    @OneToMany(mappedBy = "inventory", fetch = FetchType.EAGER)
    private Set<Product> products;

    public  Inventory(){
        products = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        product.setInventory(this);
        products.add(product);
    }

}
