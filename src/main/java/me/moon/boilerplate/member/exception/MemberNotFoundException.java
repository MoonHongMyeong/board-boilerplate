package me.moon.boilerplate.member.exception;

import me.moon.boilerplate.common.error.ErrorCode;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

    public MemberNotFoundException(String value) {
        super(value, ErrorCode.ACCOUNT_NOT_FOUND);
    }
}
