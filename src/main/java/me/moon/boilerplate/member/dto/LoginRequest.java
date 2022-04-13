package me.moon.boilerplate.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Password;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    private Email email;
    private Password password;

    @Builder
    public LoginRequest(Email email, Password password){
        this.email = email;
        this.password = password;
    }
}
