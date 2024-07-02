package com.springboot.oop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String id;
    private String pass;
    private String gender;
    private String addr1;
    private String addr2;

    public String getAddress() {
        return getAddr1() + getAddr2();
    }


}
