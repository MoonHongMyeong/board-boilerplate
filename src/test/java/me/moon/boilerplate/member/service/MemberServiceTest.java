package me.moon.boilerplate.member.service;

import me.moon.boilerplate.config.TestProfile;
import me.moon.boilerplate.config.setup.MemberBuilder;
import me.moon.boilerplate.config.setup.MemberSignupRequestBuilder;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.dto.MemberUpdateRequest;
import me.moon.boilerplate.member.exception.EmailDuplicatedException;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Member;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static com.google.common.truth.Truth.assertThat;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles(TestProfile.TEST)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberServiceTest {

    private Member member;
    private MemberSignupRequest dto;

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;
    @Mock
    private MemberFindDao memberFindDao;

    @BeforeAll
    public void setup(){
        member = MemberBuilder.build();
        dto = MemberSignupRequestBuilder.build(member);
    }

    @DisplayName("회원가입 성공")
    @Test
    public void successfullySignUp(){
        //given
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

        //when
        when(memberRepository.existsByEmail(any())).thenReturn(true);

        //then
        assertThrows(EmailDuplicatedException.class, () -> {
            memberService.signup(dto);
        });
    }

    @DisplayName("회원수정 성공")
    @Test
    public void updateMemberInfo(){
        //given
        MemberUpdateRequest updateRequest = MemberUpdateRequest.builder()
                .address(Address.builder()
                        .address1("exceptedAddress1")
                        .address2("exceptedAddress2")
                        .zipcode("exceptedZipcode")
                        .build())
                .phone("111-1111-1111")
                .build();

        given(memberFindDao.findById(anyLong())).willReturn(member);

        //when
        final MemberResponse updateMember = memberService.update(anyLong(), updateRequest);

        //then
        assertThat(updateMember.getPhone()).isEqualTo(updateRequest.getPhone());
        assertThat(updateMember.getAddress()).isEqualTo(updateRequest.getAddress());
    }
}
