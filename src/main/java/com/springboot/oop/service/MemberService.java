package com.springboot.oop.service;

import com.springboot.oop.dto.MemberDto;

public interface MemberService {

    boolean login(MemberDto memberDto);

    void join(MemberDto memberDto);

    void modify(MemberDto memberDto);

    void delete(MemberDto memberDto);

}
