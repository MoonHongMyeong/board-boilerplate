package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;
import me.moon.boilerplate.member.dto.*;
import me.moon.boilerplate.member.exception.EmailDuplicatedException;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Password;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberFindDao memberFindDao;

    public MemberResponse signup(MemberSignupRequest dto) {

        if(memberRepository.existsByEmail(dto.getEmail())){
            throw new EmailDuplicatedException(dto.getEmail());
        }

        return new MemberResponse(memberRepository.save(dto.toEntity()));
    }

    public MemberResponse update(Long memberId, MemberUpdateRequest dto) {

        Member member = memberFindDao.findById(memberId);

        member.updateMemberInfo(dto);

        return new MemberResponse(member);
    }

    public void changePassword(Long memberId, MemberPasswordUpdateRequest dto) {

        Member member = memberFindDao.findById(memberId);

        member.changePassword(dto);
    }

    public void delete(Long memberId) {

        Member member = memberFindDao.findById(memberId);

        memberRepository.delete(member);
    }

    public boolean isValidMember(LoginRequest dto) {

        Member member = memberFindDao.findByEmail(dto.getEmail());
        Password rawPassword = member.getPassword();

        if(rawPassword.isMatched(dto.getPassword().getValue())){
            return true;
        }

        return false;
    }
}
