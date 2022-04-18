package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;
import me.moon.boilerplate.member.dto.LoginRequest;
import me.moon.boilerplate.member.exception.InvalidLoginRequestException;
import me.moon.boilerplate.member.exception.MemberNotFoundException;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFindDao {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId.toString()));

        return member;
    }

    public Member findByEmail(Email email){

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException(email.getValue()));

        return member;
    }

    public Member findMemberByLoginRequest(LoginRequest dto) {
        Member member = memberRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new InvalidLoginRequestException(dto.getEmail().getValue()));

        return member;
    }
}
