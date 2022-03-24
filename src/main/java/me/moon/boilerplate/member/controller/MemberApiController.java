package me.moon.boilerplate.member.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.member.dto.MemberResponse;
import me.moon.boilerplate.member.dto.MemberSignupRequest;
import me.moon.boilerplate.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberApiController {

    private MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity signup(@RequestBody @Valid MemberSignupRequest dto){

        MemberResponse response = memberService.signup(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
