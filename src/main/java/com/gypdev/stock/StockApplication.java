package com.gypdev.stock;

import com.gypdev.stock.model.Inventory;
import com.gypdev.stock.model.Product;
import com.gypdev.stock.repository.InventoryRepository;
import com.gypdev.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository repoProduct, InventoryRepository repoInventory){


		return (args -> {

			Product product1 = new Product("Escoba", "Larga|Sintetica", 99.0, 10);
			Product product2 = new Product("Pala", "Larga|Acero", 120.0, 20);
			Product product3 = new Product("Tacho", "Largo|Plastico", 300.0, 10);

			repoProduct.save(product1);
			repoProduct.save(product2);
			repoProduct.save(product3);

			Inventory inventory = new Inventory();
			inventory.addProduct(product1);
			inventory.addProduct(product2);
			inventory.addProduct(product3);

			repoInventory.save(inventory);





		});
	}
}
