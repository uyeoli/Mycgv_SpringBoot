package com.springboot.oop.service.impl;

import com.springboot.oop.dto.MemberDto;
import com.springboot.oop.entity.Member;
import com.springboot.oop.repository.MemberRepository;
import com.springboot.oop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean login(MemberDto memberDto) {
        Member member = memberRepository.findById(memberDto.getId());
        return memberDto.getPass().equals(member.getPass());
    }

    @Override
    public void join(MemberDto memberDto) {
        Member member = Member.of(memberDto);
        memberRepository.join(member);
    }

    @Override
    public void modify(MemberDto memberDto) {
        Member member = Member.of(memberDto);
        memberRepository.modify(member);
    }

    @Override
    public void delete(MemberDto memberDto) {
        Member member = Member.of(memberDto);
        memberRepository.delete(member);
    }

}
