package com.springboot.oop.service.impl;

import com.springboot.oop.dto.BoardDto;
import com.springboot.oop.entity.Board;
import com.springboot.oop.mapper.BasicMapper;
import com.springboot.oop.mapper.BoardMapper;
import com.springboot.oop.repository.BoardRepository;
import com.springboot.oop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    /*
    다형성만 생각해서 인터페이스로 의존성을 할당할 필요가 없다.
    제네릭을 사용해서 이미 타입을 확정해놨기 때문에 여기서 만약 인터페이스로 의존성 주입 시 명시적 형변환까지 해야하는 불필요한 코드가 필요하다.
     */
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> findAll() {
        List<Board> list = boardRepository.findAll();
        return boardMapper.toDtoList(list);
    }

    @Override
    public void modify(BoardDto boardDto) {
        Board board = boardMapper.toEntity(boardDto);
        boardRepository.modify(board);
    }

    @Override
    public void delete(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getId());
        boardRepository.delete(board);
    }

    @Override
    public void save(BoardDto boardDto) {
        Board board = boardMapper.toEntity(boardDto);
        boardRepository.save(board);
    }

}
