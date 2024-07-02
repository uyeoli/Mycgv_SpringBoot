package com.springboot.oop.service.impl;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;
import com.springboot.oop.repository.BoardRepository;
import com.springboot.oop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public void modify(BoardDto boardDto) {
        Board board = boardDto.toEntity(boardDto);
        boardRepository.modify(board);
    }

    @Override
    public void delete(String id) {
        Board board = boardRepository.findById(id);
        boardRepository.delete(board.getId());
    }

    @Override
    public void save(BoardDto boardDto) {
        Board board = boardDto.toEntity(boardDto);
        boardRepository.save(board);
    }

}
