package me.moon.boilerplate.member.exception;

import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.InvalidValueException;

public class InvalidLoginRequestException extends InvalidValueException {

    public InvalidLoginRequestException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

    public InvalidLoginRequestException(String value) {
        super(value, ErrorCode.INVALID_LOGIN_REQUEST);
    }
}
