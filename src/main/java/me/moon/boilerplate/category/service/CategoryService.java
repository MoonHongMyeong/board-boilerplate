package me.moon.boilerplate.category.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.category.dto.CategoryResponse;
import me.moon.boilerplate.category.dto.CategorySaveRequest;
import me.moon.boilerplate.category.dto.CategoryUpdateRequest;
import me.moon.boilerplate.category.persistence.entity.Category;
import me.moon.boilerplate.category.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryFindDao categoryFindDao;

    @Transactional(readOnly = true)
    public List<CategoryResponse> getCategories(){
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category))
                .collect(Collectors.toList());
    }

    public void create(CategorySaveRequest dto) {
        categoryRepository.save(dto.toEntity());
    }

    public void update(Long categoryId, CategoryUpdateRequest dto) {
        Category category = categoryFindDao.findCategoryById(categoryId);

        category.update(dto);
    }

    public void delete(Long categoryId) {
        Category category = categoryFindDao.findCategoryById(categoryId);

        categoryRepository.delete(category);
    }
}
