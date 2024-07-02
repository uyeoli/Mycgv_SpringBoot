package com.springboot.old.repository;

import com.springboot.old.dto.MemberDto;
import com.springboot.old.dto.SessionDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    SessionDto login(MemberDto memberDto);
    int idCheck(String id);
    int join(MemberDto memberDto);
}
