package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;
import me.moon.boilerplate.member.dto.MemberPasswordUpdateRequest;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.dto.MemberUpdateRequest;
import me.moon.boilerplate.member.exception.EmailDuplicatedException;
import me.moon.boilerplate.member.persistence.entity.Member;
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

    public MemberResponse update(Long memberId, MemberUpdateRequest dto) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원을 찾을 수 없습니다.\n다시 확인해주세요."));

        member.updateMemberInfo(dto);

        return new MemberResponse(member);
    }

    public void changePassword(Long memberId, MemberPasswordUpdateRequest dto) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원을 찾을 수 없습니다.\n다시 확인해주세요."));

        member.changePassword(dto);
    }
}
