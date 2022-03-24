package me.moon.boilerplate.common.error.exception;

import me.moon.boilerplate.common.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

    public EntityNotFoundException(String value) {
        super(value, ErrorCode.ENTITY_NOT_FOUND);
    }
}
