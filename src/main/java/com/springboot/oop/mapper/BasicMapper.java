package com.springboot.oop.mapper;

import java.util.List;

public interface BasicMapper<E, D> {

    public E toEntity(D d);

    public D toDto(E e);

    public List<D> toDtoList(List<E> e);
}
