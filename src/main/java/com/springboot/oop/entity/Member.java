package com.springboot.oop.entity;

import com.springboot.oop.dto.MemberDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private String id;
    private String pass;
    private String gender;
    private String address;


    public static Member of(MemberDto memberDto) {
        return Member.builder()
                .id(memberDto.getId())
                .pass(memberDto.getPass())
                .gender(memberDto.getGender())
                .address(memberDto.getAddress())
                .build();

    }


}
