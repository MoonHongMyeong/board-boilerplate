package me.moon.boilerplate.category.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.category.dto.CategorySaveRequest;
import me.moon.boilerplate.category.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void create(CategorySaveRequest dto) {
        categoryRepository.save(dto.toEntity());
    }
}
