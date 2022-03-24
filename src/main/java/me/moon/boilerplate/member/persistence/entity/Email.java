package me.moon.boilerplate.member.persistence.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @javax.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String value;

    public String getHost(){
        int index = value.indexOf("@");
        return value.substring(index);
    }

    public String getId(){
        int index = value.indexOf("@");
        return value.substring(0, index);
    }

}
