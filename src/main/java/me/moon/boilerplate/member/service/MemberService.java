package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.exception.EmailDuplicatedException;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse signup(MemberSignupRequest dto) {

        if(memberRepository.existsByEmail(dto.getEmail())){
            throw new EmailDuplicatedException(dto.getEmail());
        }

        return new MemberResponse(memberRepository.save(dto.toEntity()));
    }
}
