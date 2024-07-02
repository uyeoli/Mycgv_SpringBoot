package com.springboot.old.service;

import com.springboot.old.dto.MemberDto;
import com.springboot.old.dto.SessionDto;
import com.springboot.old.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    /* 로그인 */
    public SessionDto login(MemberDto memberDto) {
        return memberMapper.login(memberDto);
    }

    /* 아이디 중복체크 */
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    /* 회원가입 */
    public int join(MemberDto memberDto) {
        return memberMapper.join(memberDto);
    }

}
