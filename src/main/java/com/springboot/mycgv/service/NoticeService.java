package com.springboot.mycgv.service;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeDto> list(PageDto pageDto) {
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("start",pageDto.getStartCount());
        param.put("end",pageDto.getEndCount());
        return noticeMapper.list(pageDto);
    }

    public NoticeDto content(String nid) {
        return noticeMapper.content(nid);
    }

    public void updateHits(String nid) {
        noticeMapper.updateHits(nid);
    }
}
