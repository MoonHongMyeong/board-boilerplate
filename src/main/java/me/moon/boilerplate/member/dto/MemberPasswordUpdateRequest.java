package me.moon.boilerplate.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class MemberPasswordUpdateRequest {

    @NotBlank
    @Pattern(message = "잘못된 비밀번호 형식입니다. \n비밀번호는 특수문자, 영문대소문자, 숫자를 포함하여 10자 이상입니다.",
            regexp = "^[a-zA-Z0-9 !@#$%^&*(),./?_]{10,}$")
    private String oldPassword;

    @NotBlank
    @Pattern(message = "잘못된 비밀번호 형식입니다. \n비밀번호는 특수문자, 영문대소문자, 숫자를 포함하여 10자 이상입니다.",
            regexp = "^[a-zA-Z0-9 !@#$%^&*(),./?_]{10,}$")
    private String newPassword;

    @Builder
    public MemberPasswordUpdateRequest(String oldPassword, String newPassword){
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
