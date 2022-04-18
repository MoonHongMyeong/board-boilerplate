package me.moon.boilerplate.member.exception;

import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;

public class UnauthorizedAccessException extends EntityNotFoundException {

    public UnauthorizedAccessException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

    public UnauthorizedAccessException(String value) {
        super(value, ErrorCode.UNAUTHORIZED_ACCESS);
    }
}
