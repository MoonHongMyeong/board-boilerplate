package me.moon.boilerplate.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Email email;
    private String name;
    private String phone;
    private Role role;

    public SessionUser(Member member){
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.role = member.getRole();
    }
}
