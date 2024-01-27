package com.gypdev.stock.DTO;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.model.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class InventoryDTO {

    private Long id;
    private Set<ProductDTO> productsDTO;

    public InventoryDTO(Inventory inventory){
        this.id = inventory.getId();
        this.productsDTO = inventory.getProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public Set<ProductDTO> getProductsDTO() {
        return productsDTO;
    }
}
