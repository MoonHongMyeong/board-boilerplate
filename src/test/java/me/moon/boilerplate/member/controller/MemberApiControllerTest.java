package me.moon.boilerplate.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.moon.boilerplate.BoilerplateApplication;
import me.moon.boilerplate.config.TestProfile;
import me.moon.boilerplate.config.setup.MemberBuilder;
import me.moon.boilerplate.config.setup.MemberSignupRequestBuilder;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.persistence.entity.Address;
import me.moon.boilerplate.member.persistence.entity.Email;
import me.moon.boilerplate.member.persistence.entity.Member;
import me.moon.boilerplate.member.persistence.entity.Password;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BoilerplateApplication.class)
@ActiveProfiles(TestProfile.TEST)
@Transactional
@AutoConfigureMockMvc
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberApiControllerTest {

    @Autowired
    protected MockMvc mvc;
    @Autowired
    protected WebApplicationContext context;
    @Autowired
    protected ObjectMapper objectMapper;

    private Member member;
    private MemberSignupRequest signupDto;

    @BeforeAll
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        member = MemberBuilder.build();
    }

    @DisplayName("회원가입 성공")
    @Test
    public void successfullySignUp() throws Exception {
        //given
        signupDto = MemberSignupRequestBuilder.build(member);

        //when
        final ResultActions resultActions = mvc.perform(post("/api/v1/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(signupDto)))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("email.value").value(member.getEmail().getValue()))
                .andExpect(jsonPath("email.host").value(member.getEmail().getHost()))
                .andExpect(jsonPath("email.id").value(member.getEmail().getId()))
                .andExpect(jsonPath("address.address1").value(member.getAddress().getAddress1()))
                .andExpect(jsonPath("address.address2").value(member.getAddress().getAddress2()))
                .andExpect(jsonPath("address.zipcode").value(member.getAddress().getZipcode()))
                .andExpect(jsonPath("name").value(member.getName()))
                .andExpect(jsonPath("phone").value(member.getName()));

    }

}
