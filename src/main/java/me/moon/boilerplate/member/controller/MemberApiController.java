package me.moon.boilerplate.member.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.common.model.SessionUser;
import me.moon.boilerplate.member.dto.*;
import me.moon.boilerplate.member.service.LoginService;
import me.moon.boilerplate.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberApiController {

    private final MemberService memberService;
    private final LoginService loginService;

    @PostMapping("/member")
    public ResponseEntity signup(@RequestBody @Valid MemberSignupRequest dto){

        MemberResponse response = memberService.signup(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity update(@RequestBody @Valid MemberUpdateRequest dto, @PathVariable(name = "memberId") Long memberId){

        MemberResponse response = memberService.update(memberId, dto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/member/{memberId}/password")
    public ResponseEntity update(@RequestBody @Valid MemberPasswordUpdateRequest dto, @PathVariable(name = "memberId") Long memberId){

        memberService.changePassword(memberId, dto);

        return ResponseEntity.ok("비밀번호를 변경했습니다.");
    }

    @DeleteMapping("/member/{memberId}")
    public ResponseEntity withdrawal(@PathVariable(name = "memberId") Long memberId){

        memberService.delete(memberId);

        return ResponseEntity.ok("회원 탈퇴를 완료했습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest dto){

        if(memberService.isValidMember(dto)){

            SessionUser member = memberService.findMemberByLoginRequest(dto);
            loginService.login(member);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){

        loginService.logout();

        return ResponseEntity.ok().build();
    }
}
