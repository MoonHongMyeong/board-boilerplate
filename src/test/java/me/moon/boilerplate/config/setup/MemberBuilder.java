package me.moon.boilerplate.config.setup;

import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Password;

public class MemberBuilder {

    public static Member build(){
        return Member.builder()
                .address(Address
                        .builder()
                        .address1("TestAddress1")
                        .address2("TestAddress2")
                        .zipcode("TestZipcode")
                        .build())
                .email(Email
                        .builder()
                        .value("testEmail@test.com")
                        .build())
                .password(Password
                        .builder()
                        .value("TestPassword")
                        .build())
                .name("TestUser")
                .phone("000-0000-0000")
                .build();
    }
}
