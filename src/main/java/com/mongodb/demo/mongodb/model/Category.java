package com.mongodb.demo.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@Builder
@Document(collection = "category")

public class Category {
    @Id
    private String id;
    private String name;
    private String description;

    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
    }
}
