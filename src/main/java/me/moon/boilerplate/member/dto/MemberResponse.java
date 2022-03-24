package me.moon.boilerplate.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private Long id;
    private Email email;
    private String name;
    private String phone;
    private Address address;
    private String role;

    public MemberResponse(final Member member){
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.role = member.getRole().getRoleName();
    }
}
