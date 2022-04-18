package me.moon.boilerplate.member.service;

import me.moon.boilerplate.common.model.SessionUser;
import me.moon.boilerplate.member.persistence.entity.Member;

public interface LoginService {

    void login(SessionUser loginMember);

    void logout();

    Member getLoginMember();
}
