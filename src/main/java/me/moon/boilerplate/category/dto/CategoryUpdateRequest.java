package me.moon.boilerplate.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.category.persistence.entity.Category;

@Getter
@NoArgsConstructor
public class CategoryUpdateRequest {

    private String name;
    private Category category;

    @Builder
    public CategoryUpdateRequest(String name, Category category){
        this.name = name;
        this.category = category;
    }
}
