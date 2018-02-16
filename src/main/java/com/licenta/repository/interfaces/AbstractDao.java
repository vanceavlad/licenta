package com.licenta.repository.interfaces;


import java.util.List;

public interface AbstractDao<T,E> {
    T findById(E entityId);
    List<T> getAll();
    Integer create(T entity);
    void update(T entity);
    boolean delete(E entityId);
}
