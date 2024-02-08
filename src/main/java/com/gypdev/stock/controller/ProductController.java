package com.gypdev.stock.controller;


import com.gypdev.stock.DTO.ProductDTO;
import com.gypdev.stock.model.Product;
import com.gypdev.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Transactional
    @PostMapping("/products")
    public ResponseEntity<Object> updateStockProduct(@RequestParam int quantity, Product product) {
        if (quantity >= 0) {
            product.setStock(quantity);
            return new ResponseEntity<>("The product is update", HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>("An error has occurred", HttpStatus.NOT_MODIFIED);
        }


    }
}
