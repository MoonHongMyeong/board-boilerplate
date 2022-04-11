package me.moon.boilerplate.member.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.error.exception.EntityNotFoundException;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFindDao {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원을 찾을 수 없습니다.\n다시 확인해주세요."));

        return member;
    }
}
