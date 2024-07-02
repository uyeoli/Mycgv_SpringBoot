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
    public boolean login(String id, String pass) {
        Member member = memberRepository.findById(id);
        return pass.equals(member.getPass());
    }

    @Override
    public void join(MemberDto memberDto) {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setPass(memberDto.getPass());
        member.setGender(memberDto.getGender());
        member.setAddress(member.combineAddress(memberDto.getAddr1(), memberDto.getAddr2()));
        memberRepository.join(member);
    }

    @Override
    public void modify(MemberDto memberDto) {
        Member member = memberRepository.findById(memberDto.getId());
        member.setId(memberDto.getId());
        member.setPass(memberDto.getPass());
        member.setGender(memberDto.getGender());
        member.setAddress(member.combineAddress(memberDto.getAddr1(), memberDto.getAddr2()));
        memberRepository.modify(member);
    }

    @Override
    public void delete(String id) {
        memberRepository.delete(id);
    }

}
