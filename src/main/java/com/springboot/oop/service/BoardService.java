package com.springboot.oop.service;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;

import java.util.List;

public interface BoardService {

    List<BoardDto> findAll();

    void modify(BoardDto boardDto);

    void delete(BoardDto boardDto);

    void save(BoardDto boardDto);


}
