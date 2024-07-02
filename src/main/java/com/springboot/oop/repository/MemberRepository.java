package com.springboot.oop.repository;

import com.springboot.oop.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {

    void join(Member member);

    void delete(String id);

    void modify(Member member);

    Member findById(String id);




}
