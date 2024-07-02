package com.springboot.oop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String pass;
    private String gender;
    private String address;

    public String combineAddress(String addr1, String addr2) {
        return addr1 + addr2;
    }


}
