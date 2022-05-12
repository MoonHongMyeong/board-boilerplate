package me.moon.boilerplate.category.persistence.repository;

import me.moon.boilerplate.category.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findBycategoryName(String categoryName);
}