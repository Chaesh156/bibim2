package com.chaesh.Domain.dailyPlan.controller;

import com.chaesh.Domain.dailyPlan.dto.MemberFirebaseTokenRequestDto;
import com.chaesh.Domain.dailyPlan.dto.MemberRequestDto;
import com.chaesh.Domain.dailyPlan.dto.MemberResponseDto;
import com.chaesh.Domain.dailyPlan.service.MemberService;
import com.chaesh.Global.result.ResultCode;
import com.chaesh.Global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
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

    @GetMapping("/member/email/{email}")
    public MemberResponseDto findByEmail(@PathVariable String email){
        return memberService.findByEmail(email);
    }

    @PostMapping("/firebaseToken/{memberId}")
    public ResponseEntity<ResultResponse> saveOrUpdateFirebaseToken(@PathVariable Long memberId, @RequestBody MemberFirebaseTokenRequestDto requestDto){
        boolean isSave = memberService.saveOrUpdateFireBaseTokenByMemberId(memberId, requestDto);

        return ResponseEntity.ok(ResultResponse.of(SAVE_OR_UPDATE_FIREBASE_TOKEN_SUCCESS,isSave));
    }
}
