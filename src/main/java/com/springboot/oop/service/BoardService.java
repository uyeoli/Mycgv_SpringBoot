package com.springboot.oop.service;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> findAll();

    void modify(BoardDto boardDto);

    void delete(String id);

    void save(BoardDto boardDto);


}
