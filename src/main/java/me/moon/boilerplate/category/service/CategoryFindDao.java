package me.moon.boilerplate.category.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.category.exception.CategoryNotFoundException;
import me.moon.boilerplate.category.persistence.entity.Category;
import me.moon.boilerplate.category.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryFindDao {

    private final CategoryRepository categoryRepository;

    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId.toString()));
    }

    public Category findCategoryByName(String categoryName){
        return categoryRepository.findBycategoryName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException(categoryName));
    }
}
