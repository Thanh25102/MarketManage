package org.nam16tuoimatem.dao;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    T findOne(Integer id);

    T saveOrUpdate(T data);

    void delete(Integer id);
}
