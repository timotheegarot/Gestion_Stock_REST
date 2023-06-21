package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("/*")
@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product")
    public List<Product> getProductList() {
        return productRepo.findAll();
    }

    @GetMapping("/product/{productId}")
    public Optional<Product> getProductById(@PathVariable(name = "productId") Long id) {
        return productRepo.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/product/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable(name = "productId") Long id) {
        product.setId(id);
        return productRepo.save(product);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable(name = "productId") Long id) {
        productRepo.deleteById(id);
    }
}
