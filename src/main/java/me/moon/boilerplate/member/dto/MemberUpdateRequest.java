package me.moon.boilerplate.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Password;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateRequest {

    @NotEmpty
    private Password password;

    @NotBlank
    @Pattern(message = "유효하지 않은 전화번호 형식입니다.",
            regexp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$")
    private String phone;

    @NotEmpty
    private Address address;

    @Builder
    public MemberUpdateRequest(String phone, Address address){
        this.phone = phone;
        this.address = address;
    }
}
