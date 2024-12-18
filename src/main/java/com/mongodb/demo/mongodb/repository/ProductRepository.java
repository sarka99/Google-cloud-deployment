package com.mongodb.demo.mongodb.repository;

import com.mongodb.demo.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
