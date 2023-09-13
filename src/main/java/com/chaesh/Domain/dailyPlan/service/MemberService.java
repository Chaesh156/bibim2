package com.chaesh.Domain.dailyPlan.service;

import com.chaesh.Domain.dailyPlan.dto.MemberFirebaseTokenRequestDto;
import com.chaesh.Domain.dailyPlan.dto.MemberRequestDto;
import com.chaesh.Domain.dailyPlan.dto.MemberResponseDto;
import com.chaesh.Domain.member.Member;
import com.chaesh.Domain.member.MemberRepository;
import com.chaesh.Global.error.exception.MemberNotExistException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.chaesh.Global.error.ErrorCode.MEMBER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberRequestDto requestDto){
        Member member = requestDto.toEntity();
        return memberRepository.save(member).getId();
    }

    @Transactional
    public boolean saveOrUpdateFireBaseTokenByMemberId(Long memberId, MemberFirebaseTokenRequestDto requestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException());
        member.setFirebaseToken(requestDto.getFirebaseToken());
        return true;
    }

    public MemberResponseDto findById(Long id){
        Member entity = memberRepository.findById(id)
                .orElseThrow(()-> new MemberNotExistException("해당 id를 가진 member가 없습니다. id="+id));

        return new MemberResponseDto(entity);
    }

    public MemberResponseDto findByEmail(String email){
        Member entity = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberNotExistException("해당 email을 가진 member가 없습니다. email="+email));

        return new MemberResponseDto(entity);
    }


}
