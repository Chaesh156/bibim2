package com.chaesh.Domain.dailyPlan.controller;

import com.chaesh.Domain.dailyPlan.dto.MemberRequestDto;
import com.chaesh.Domain.dailyPlan.dto.MemberResponseDto;
import com.chaesh.Domain.dailyPlan.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long save(@RequestBody MemberRequestDto requestDto){
        return memberService.save(requestDto);
    }

    @GetMapping("/member/{member_id}")
    public MemberResponseDto findById(@PathVariable Long member_id){
        return memberService.findById(member_id);
    }

    @GetMapping("/member/{email}")
    public MemberResponseDto findByEmail(@PathVariable String email){
        return memberService.findByEmail(email);
    }
}
