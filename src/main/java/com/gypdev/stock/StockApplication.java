package com.gypdev.stock;

import com.gypdev.stock.model.Product;
import com.gypdev.stock.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;

import static com.gypdev.stock.Utils.Util.generateCode;


@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository repoProduct){


		return (args -> {

			Product product1 = new Product(generateCode(),"Escoba", "Larga|Sintetica", 99.0, 10, "https://i.ibb.co/RjfTXXB/escoba.webp");
			Product product2 = new Product(generateCode(),"Pala", "Larga|Acero", 120.0, 20,"https://img2.freepnges.com/20190709/eop/kisspng-hand-tool-spade-shovel-digging-5d24aeb17ec058.6229438415626851055192.jpg");
			Product product3 = new Product(generateCode(),"Tacho", "Largo|Plastico", 300.0, 10,"https://i.ibb.co/DLgDVGS/tacho.jpg");

			System.out.println("APP READY!!!");


			repoProduct.save(product1);
			repoProduct.save(product2);
			repoProduct.save(product3);








		});
	}
}
