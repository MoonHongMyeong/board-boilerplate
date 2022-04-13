package me.moon.boilerplate.member.service;

import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;

public interface LoginService {

    void login(Email email);

    void logout();

    Member getLoginMember();
}
