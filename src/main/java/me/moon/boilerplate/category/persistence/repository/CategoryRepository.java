package me.moon.boilerplate.category.persistence.repository;

import me.moon.boilerplate.category.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}