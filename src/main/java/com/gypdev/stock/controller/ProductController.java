package com.gypdev.stock.controller;


import com.gypdev.stock.DTO.ProductDTO;
import com.gypdev.stock.model.Product;
import com.gypdev.stock.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.gypdev.stock.Utils.Util.generateCode;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository repoProduct;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repoProduct.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return repoProduct.findById(id).map(product -> new ProductDTO(product)).orElse(null);
    }

    @Transactional
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestParam String name, @RequestParam String description,
                                                @RequestParam Double price, @RequestParam int stock) {


        /*if (!image.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static//web/img");
            String rutaAbs = directorio.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();
                Path rutaCompleta = Paths.get(rutaAbs + "//" + image.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                System.out.println(image.getOriginalFilename());

                //producto.setPathImage(image.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        Product producto = new Product(generateCode(), name, description, price, stock, "image.getOriginalFilename()");
        repoProduct.save(producto);
        return new ResponseEntity<>("The product is update", HttpStatus.ACCEPTED);
        }

    }




    //TODO hacer un post para actualizar precio y stock unicamente
    /*@PostMapping("/products")
    public ResponseEntity<Object> updateStockProduct(@RequestParam int quantity, Product product) {
        if (quantity >= 0) {
            product.setStock(quantity);
            return new ResponseEntity<>("The product is update", HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>("An error has occurred", HttpStatus.NOT_MODIFIED);
        }


    }*/

