package com.springboot.old.repository;

import com.springboot.old.dto.NoticeDto;
import com.springboot.old.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> list(PageDto pageDto);
    NoticeDto content(String nid);
    void updateHits(String nid);
}
