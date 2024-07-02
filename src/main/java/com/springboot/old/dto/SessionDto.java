package com.springboot.old.dto;

import lombok.Data;

@Data
public class SessionDto {
    private int loginresult;
    private String name, id;
}
