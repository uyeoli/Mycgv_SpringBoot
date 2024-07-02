package com.springboot.oop.mapper;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardMapper implements BasicMapper<Board, BoardDto>{

    @Override
    public Board toEntity(BoardDto boardDto) {
        return Board.builder()
                .id(boardDto.getId())
                .btitle(boardDto.getBtitle())
                .bcontent(boardDto.getBcontent())
                .bdate(boardDto.getBdate())
                .build();
    }

    @Override
    public BoardDto toDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setBcontent(board.getBcontent());
        boardDto.setBtitle(board.getBtitle());
        boardDto.setBdate(board.getBdate());
        return boardDto;
    }

    @Override
    public List<BoardDto> toDtoList(List<Board> boardList) {
        List<BoardDto> dtoList = new ArrayList<>();
        for(Board board : boardList) {
            dtoList.add(toDto(board));
        }
        return dtoList;
    }
}
