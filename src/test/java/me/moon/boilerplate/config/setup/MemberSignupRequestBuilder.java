package me.moon.boilerplate.config.setup;

import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.persistence.entity.Member;

public class MemberSignupRequestBuilder {

    public static MemberSignupRequest build(Member member){
        return MemberSignupRequest
                .builder()
                .address(member.getAddress())
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .phone(member.getPhone())
                .build();
    }
}
