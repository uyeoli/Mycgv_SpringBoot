package com.springboot.mycgv.dto;

import lombok.Data;

@Data
public class MemberDto {
    //폼에서 넘어오는 모든 name/value 저장
    String id, pass, name, gender, email1, email2, addr1, addr2, tel,
            phone1, phone2, phone3,  intro, grade;
    String[] hobby; // checkbox로 넘어오는 데이터는 배열

    //member 테이블에 컬럼 매핑
    int rno;
    String email, addr, pnumber, hobbyList, mdate;
    // email --> 폼에서 set X, 테이블 set O
    // email --> 폼에서 get O(email1 + "@" + email2), 테이블 get O

    //메소드
    public String getEmail() {
        if(email1 != null) { // 폼에서 email 주소가 넘어온 경우
            email = email1 + "@" + email2;
        }
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddr() {
        if(addr1 != null) {
            addr = addr1 + addr2;
        }
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getPnumber() {
        if(phone1 != null) {
            pnumber = phone1 + "-" + phone2 + "-" + phone3;
        }
        return pnumber;
    }
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getHobbyList() {
        if(hobby != null) {
            hobbyList = String.join(",", hobby);
        }
        return hobbyList;
    }
    public void setHobbyList(String hobbyList) {
        this.hobbyList = hobbyList;
    }
}
