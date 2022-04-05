package me.moon.boilerplate.member.persistence.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @javax.validation.constraints.Email
    @Column(name = "email", nullable = false)
    private String value;

    public String getHost(){
        int index = value.indexOf("@");
        return value.substring(index);
    }

    public String getId(){
        int index = value.indexOf("@");
        return value.substring(0, index);
    }

    @Builder
    public Email(String value){
        this.value = value;
    }

}
