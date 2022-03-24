package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberResponse signup(MemberSignupRequest dto) {
        return new MemberResponse(memberRepository.save(dto.toEntity()));
    }
}
