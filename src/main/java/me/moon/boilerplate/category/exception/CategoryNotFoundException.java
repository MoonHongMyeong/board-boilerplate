package me.moon.boilerplate.category.exception;

import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {

    public CategoryNotFoundException(String value) {
        super(value, ErrorCode.CATEGORY_NOT_FOUND);
    }
}
