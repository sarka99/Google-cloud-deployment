package com.mongodb.demo.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "products")

public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    @DBRef
    private Category category;

    public Product() {
    }

    public Product(String name, String description, List<String> tags, Category category) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.category = category;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
