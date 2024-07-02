package com.springboot.oop.repository;

import com.springboot.oop.entity.Board;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BoardRepository {

    List<Board> findAll();

    void modify(Board board);

    void delete(String id);

    void save(Board board);

    Board findById(String id);

}
