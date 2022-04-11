package me.moon.boilerplate.member.persistence.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.common.model.BaseTimeEntity;
import me.moon.boilerplate.member.dto.MemberPasswordUpdateRequest;
import me.moon.boilerplate.member.dto.MemberUpdateRequest;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role Role;

    @Builder
    public Member(Email email, Password password, String name, String phone, Address address){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.Role = me.moon.boilerplate.member.persistence.entity.Role.USER;
    }

    public void updateMemberInfo(MemberUpdateRequest dto) {
        this.phone = dto.getPhone();
        this.address = dto.getAddress();
    }

    public void changePassword(MemberPasswordUpdateRequest dto) {
        password.changePassword(dto.getOldPassword(), dto.getNewPassword());
    }
}