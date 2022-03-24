package me.moon.boilerplate.member.persistence.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum Role {

    ADMIN, USER;

    private String role;
}
