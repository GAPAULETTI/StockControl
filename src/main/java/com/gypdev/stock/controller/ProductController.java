package com.gypdev.stock.controller;


import com.gypdev.stock.DTO.ProductDTO;
import com.gypdev.stock.model.Product;
import com.gypdev.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository repoProduct;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return repoProduct.findAll();
    }
    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return repoProduct.findById(id).map(product -> new ProductDTO(product)).orElse(null);
    }
}
