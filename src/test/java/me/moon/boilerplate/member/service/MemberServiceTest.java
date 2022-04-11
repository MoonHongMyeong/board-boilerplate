package me.moon.boilerplate.member.service;

import me.moon.boilerplate.config.TestProfile;
import me.moon.boilerplate.config.setup.MemberBuilder;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.exception.EmailDuplicatedException;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Password;
import me.moon.boilerplate.member.persistence.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static com.google.common.truth.Truth.assertThat;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles(TestProfile.TEST)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberServiceTest {

    private Member member;

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @BeforeAll
    public void setup(){
        member = MemberBuilder.build();
    }

    @DisplayName("회원가입 성공")
    @Test
    public void successfullySignUp(){
        //given
        final Email email = member.getEmail();
        final Address address = member.getAddress();
        final Password password = member.getPassword();
        final String name = member.getName();
        final String phone = member.getPhone();

        final MemberSignupRequest dto = MemberSignupRequest
                .builder()
                .address(address)
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();

        given(memberRepository.existsByEmail(any())).willReturn(false);
        given(memberRepository.save(any())).willReturn(member);

        //when
        final MemberResponse signUpMember = memberService.signup(dto);

        //then
        assertThat(signUpMember).isNotNull();
        assertThat(signUpMember.getAddress()).isEqualTo(member.getAddress());
        assertThat(signUpMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(signUpMember.getName()).isEqualTo(member.getName());
        assertThat(signUpMember.getPhone()).isEqualTo(member.getPhone());
    }

    @DisplayName("회원가입 시 이메일 중복")
    @Test
    public void duplicatedEmailExceptionWhenSignUp(){
        //given
        final Email email = member.getEmail();
        final Address address = member.getAddress();
        final Password password = member.getPassword();
        final String name = member.getName();
        final String phone = member.getPhone();

        final MemberSignupRequest dto = MemberSignupRequest
                .builder()
                .address(address)
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();

        //when
        when(memberRepository.existsByEmail(any())).thenReturn(true);

        //then
        assertThrows(EmailDuplicatedException.class, () -> {
            memberService.signup(dto);
        });
    }
}
