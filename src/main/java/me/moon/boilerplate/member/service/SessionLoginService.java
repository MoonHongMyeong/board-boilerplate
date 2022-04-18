package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.model.SessionUser;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService{

    private final HttpSession httpSession;
    private final MemberFindDao memberFindDao;
    public static final String USER = "USER";

    @Override
    public void login(SessionUser loginMember) {
        httpSession.setAttribute(USER, loginMember);
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(USER);
    }

    @Override
    public Member getLoginMember() {

        Long memberId = (Long) httpSession.getAttribute(USER);

        return memberFindDao.findById(memberId);
    }
}
