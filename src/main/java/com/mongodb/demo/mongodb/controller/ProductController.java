package com.mongodb.demo.mongodb.controller;

import com.mongodb.demo.mongodb.DTO.CreateProductDTO;
import com.mongodb.demo.mongodb.model.Product;
import com.mongodb.demo.mongodb.service.interfaces.implementations.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<CreateProductDTO> createProduct(@RequestBody CreateProductDTO createProductDTO){
        return ResponseEntity.ok(productService.saveProduct(createProductDTO));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product-id") String productId){
        Product product = productService.findProductById(productId);
        return ResponseEntity.ok(product);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> delete(@PathVariable("product-id") String productId){
        productService.deleteProductById(productId);
        return ResponseEntity.accepted().build();
    }
}
