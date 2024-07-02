package com.springboot.oop.controller;

import com.springboot.oop.entity.Board;
import com.springboot.oop.service.BoardService;
import com.springboot.oop.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<BoardDto> list = boardService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BoardDto boardDto) {
        boardService.save(boardDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> modify(@RequestBody BoardDto boardDto) {
        boardService.modify(boardDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody BoardDto boardDto) {
        boardService.delete(boardDto);
        return ResponseEntity.ok().build();
    }


}
