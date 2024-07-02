package com.springboot.old.repository;

import com.springboot.old.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {
    int totalRowCount(PageDto pageDto);
}
