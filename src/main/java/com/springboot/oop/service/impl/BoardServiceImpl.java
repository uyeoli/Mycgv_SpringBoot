package com.springboot.oop.service.impl;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;
import com.springboot.oop.mapper.BasicMapper;
import com.springboot.oop.repository.BoardRepository;
import com.springboot.oop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BasicMapper basicMapper;

    @Override
    public List<BoardDto> findAll() {
        List<Board> list = boardRepository.findAll();
        return basicMapper.toDtoList(list);
    }

    @Override
    public void modify(BoardDto boardDto) {
        Board board = (Board) basicMapper.toEntity(boardDto);
        boardRepository.modify(board);
    }

    @Override
    public void delete(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getId());
        boardRepository.delete(board);
    }

    @Override
    public void save(BoardDto boardDto) {
        Board board = (Board) basicMapper.toEntity(boardDto);
        boardRepository.save(board);
    }

}
