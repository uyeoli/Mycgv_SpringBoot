package com.springboot.oop.dto;

import com.springboot.oop.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {

    private String id;
    private String pass;
    private String gender;
    private String addr1;
    private String addr2;


}
