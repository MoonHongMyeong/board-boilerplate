package me.moon.boilerplate.category.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.category.dto.CategorySaveRequest;
import me.moon.boilerplate.category.dto.CategoryUpdateRequest;
import me.moon.boilerplate.category.persistence.entity.Category;
import me.moon.boilerplate.category.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryFindDao categoryFindDao;

    public void create(CategorySaveRequest dto) {
        categoryRepository.save(dto.toEntity());
    }

    public void update(Long categoryId, CategoryUpdateRequest dto) {
        Category category = categoryFindDao.findCategoryById(categoryId);

        category.update(dto);
    }

}
