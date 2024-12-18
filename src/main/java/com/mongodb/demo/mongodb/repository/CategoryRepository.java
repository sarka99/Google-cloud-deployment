package com.mongodb.demo.mongodb.repository;

import com.mongodb.demo.mongodb.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
