package me.moon.boilerplate.category.dto;

import lombok.Getter;
import me.moon.boilerplate.category.persistence.entity.Category;

@Getter
public class CategoryResponse {

    private Long id;
    private String name;
    private Category parent;

    public CategoryResponse(final Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.parent = category.getParent();
    }
}
