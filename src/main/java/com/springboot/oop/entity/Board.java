package com.springboot.oop.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {

    private String id;

    private String btitle;

    private String bcontent;

    private String bdate;

}
