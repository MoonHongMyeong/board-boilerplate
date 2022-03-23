package me.moon.boilerplate.common.error.exception;

import me.moon.boilerplate.common.error.ErrorCode;

public class InvalidValueException extends BusinessException{

    public InvalidValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

    public InvalidValueException(String value) {
        super(value, ErrorCode.INVALID_INPUT_VALUE);
    }
}
