package com.springboot.oop.dto;

import com.springboot.oop.entity.Board;
import lombok.Getter;

@Getter
public class BoardDto {

    private String id;

    private String btitle;

    private String bcontent;

    private String bdate;

    public Board toEntity(BoardDto boardDto) {
        return Board.builder()
                .id(boardDto.getId())
                .btitle(boardDto.getBtitle())
                .bcontent(boardDto.getBcontent())
                .bdate(boardDto.getBdate())
                .build();
    }

}
