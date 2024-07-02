package com.springboot.oop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String id; //수정, 삭제
    private String pass; // 생성, 수정
    private String gender; // 생성, 수정
    private String addr1; // 생성, 수정
    private String addr2; // 생성, 수정

    /*
    DTO의 분리는 역할에 따라 분리하면 된다. 위에 있는 역할은 생성, 수정, 삭제 3가지
    DTO - MemberCreationDto, MemberUpdateDto, MemberDeleteDto 3가지로 분리 가능
    컨트롤러에서 api마다 필요한 역할을 파라미터로 받아 역할에 맞게 사용 시 유지보수가 편리해진다.
     */
    public String getAddress() {
        return getAddr1() + getAddr2();
    }


}
