package me.moon.boilerplate.member.exception;

import lombok.Getter;
import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.InvalidValueException;

@Getter
public class PasswordFailedExceededException extends InvalidValueException {

    public PasswordFailedExceededException() {
        super(ErrorCode.PASSWORD_FAILED_EXCEEDED.getMessage(), ErrorCode.PASSWORD_FAILED_EXCEEDED);
    }
}
