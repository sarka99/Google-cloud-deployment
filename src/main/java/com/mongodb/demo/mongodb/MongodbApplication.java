package com.mongodb.demo.mongodb;

import com.mongodb.demo.mongodb.model.Category;
import com.mongodb.demo.mongodb.model.Product;
import com.mongodb.demo.mongodb.repository.CategoryRepository;
import com.mongodb.demo.mongodb.repository.ProductRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbApplication {
	@Autowired
	private MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository){
		return args -> {
			var category = Category.builder().name("Computers").description("Laptops im selling").build();
			var category2 = Category.builder().name("phones").description("the phones im selling").build();

			var product = Product.builder().name("Macbook pro 13").description("has an m2 processor").build();
			categoryRepository.insert(category);
			productRepository.insert(product);

			categoryRepository.insert(category2);

		};
	}

 */
	@PostConstruct
	public void testDbConnection() {
		System.out.println("Connected to: " + mongoTemplate.getDb().getName());
	}

}
