package com.mongodb.demo.mongodb.service.interfaces;

import com.mongodb.demo.mongodb.DTO.CreateProductDTO;
import com.mongodb.demo.mongodb.model.Product;

import java.util.List;

public interface IProductService {
    CreateProductDTO saveProduct(CreateProductDTO createProductDTO);
    Product findProductById(String productId);

    List<Product> findAllProducts();
    void deleteProductById(String id);

}
