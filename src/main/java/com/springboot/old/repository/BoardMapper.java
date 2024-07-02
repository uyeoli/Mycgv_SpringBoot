package com.springboot.old.repository;

import com.springboot.old.dto.BoardDto;
import com.springboot.old.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> list(PageDto pageDto);
    BoardDto content(String bid);
    int insert(BoardDto boardDto);
    int update(BoardDto boardDto);
    void updateHits(String bid);
    int delete(String bid);
    String getBsfile(String bid);
}
