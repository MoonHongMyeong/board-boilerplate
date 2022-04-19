package me.moon.boilerplate.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.category.persistence.entity.Category;

@Getter
@NoArgsConstructor
public class CategorySaveRequest {

    private String name;

    private Category parent;

    @Builder
    public CategorySaveRequest(String name, Category category){
        this.name = name;
        this.parent = category;
    }

    public Category toEntity(){
        return Category.builder()
                .name(name)
                .category(parent)
                .build();
    }
}
