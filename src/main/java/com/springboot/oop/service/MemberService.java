package com.springboot.oop.service;

import com.springboot.oop.dto.MemberDto;

public interface MemberService {

    boolean login(String id, String pass);

    void join(MemberDto memberDto);

    void modify(MemberDto memberDto);

    void delete(String id);

}
