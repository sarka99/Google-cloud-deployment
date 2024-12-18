package com.mongodb.demo.mongodb.service.interfaces.implementations;

import com.mongodb.demo.mongodb.DTO.CreateProductDTO;
import com.mongodb.demo.mongodb.model.Product;
import com.mongodb.demo.mongodb.repository.ProductRepository;
import com.mongodb.demo.mongodb.service.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching

public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public CreateProductDTO saveProduct(CreateProductDTO createProductDTO) {
        System.out.println("Saving a product..");
        if(createProductDTO.getName().trim().isEmpty() || createProductDTO.getDescription().trim().isEmpty()){
            throw new IllegalArgumentException("Product name and desc cannot be empty!");
        }
        productRepository.insert(new Product(createProductDTO.getName(),createProductDTO.getDescription(), createProductDTO.getTags(),createProductDTO.getCategory()));
        return createProductDTO;
    }

    @Override
    @Cacheable("product")
    public Product findProductById(String productId) {
        //First fetch specific product from db
        System.out.println("Fetching product from db: " );
        Product product = productRepository.findById(productId).get();
        return product;
    }

    @Override
    @Cacheable("products")
    public List<Product> findAllProducts() {
        System.out.println("Finding all products from db");
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public void deleteProductById(String id) {
        System.out.println("Deleting produdct with id: " + id);
        productRepository.deleteById(id);

    }
}
