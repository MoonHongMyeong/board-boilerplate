package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService{

    private final HttpSession httpSession;
    private final MemberFindDao memberFindDao;
    public static final String MEMBER_EMAIL = "MEMBER_EMAIL";

    @Override
    public void login(Email email) {
        httpSession.setAttribute(MEMBER_EMAIL, email);
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(MEMBER_EMAIL);
    }

    @Override
    public Member getLoginMember() {

        Long memberId = (Long) httpSession.getAttribute(MEMBER_EMAIL);

        return memberFindDao.findById(memberId);
    }
}
