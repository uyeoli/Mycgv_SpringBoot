package com.springboot.mycgv.service;

import com.springboot.mycgv.dto.BoardDto;
import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.repository.BoardMapper;
import com.springboot.mycgv.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDto> list(PageDto pageDto) {
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("start",pageDto.getStartCount());
        param.put("end",pageDto.getEndCount());
        return boardMapper.list(pageDto);
    }

    public BoardDto content(String bid) {
        return boardMapper.content(bid);
    }

    public int insert(BoardDto boardDto) {
        return boardMapper.insert(boardDto);
    }

    public int update(BoardDto boardDto) {
        return boardMapper.update(boardDto);
    }

    public void updateHits(String bid) {
        boardMapper.updateHits(bid);
    }

    public int delete(String bid) {
        return boardMapper.delete(bid);
    }

    public String getBsfile(String bid) {
        return boardMapper.getBsfile(bid);
    }
}
