package com.mongodb.demo.mongodb.DTO;

import com.mongodb.demo.mongodb.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateProductDTO {
    private String name;
    private String description;
    private List<String> tags;
    private Category category;


    public CreateProductDTO(String name, String description,List<String> tags, Category category) {
        this.name = name;
        this.description = description;
        this.tags= tags;
        this.category = category;
    }
}
