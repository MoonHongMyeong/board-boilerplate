package me.moon.boilerplate.member.exception;

import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.InvalidValueException;
import me.moon.boilerplate.member.persistence.entity.Email;

public class EmailDuplicatedException extends InvalidValueException {

    public EmailDuplicatedException(Email email) {
        super(email.getValue(), ErrorCode.EMAIL_DUPLICATION);
    }
}
