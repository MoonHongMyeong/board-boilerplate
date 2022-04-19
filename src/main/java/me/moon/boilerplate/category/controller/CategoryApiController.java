package me.moon.boilerplate.category.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.category.dto.CategorySaveRequest;
import me.moon.boilerplate.category.service.CategoryService;
import me.moon.boilerplate.common.annotation.LoginRequired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class CategoryApiController {

    private final CategoryService categoryService;

    @LoginRequired
    @PostMapping("/category")
    public ResponseEntity createCategory(@Valid @RequestBody CategorySaveRequest dto){

        categoryService.create(dto);

        return ResponseEntity.status(201).build();
    }
}
