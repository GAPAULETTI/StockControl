package com.gypdev.stock.DTO;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.model.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class InventoryDTO {

    private Set<ProductDTO> productsDTO;

    public InventoryDTO(Inventory inventory){
        this.productsDTO = inventory.getProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toSet());
    }



    public Set<ProductDTO> getProductsDTO() {
        return productsDTO;
    }
}
