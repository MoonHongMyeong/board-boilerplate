package me.moon.boilerplate.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Password;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignupRequest implements Serializable {

    @Valid
    private Email email;
    @Valid
    private Password password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @Valid
    private Address address;

    @Builder
    public MemberSignupRequest(Email email, Password password, String name, String phone, Address address){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .address(address)
                .build();
    }
}
