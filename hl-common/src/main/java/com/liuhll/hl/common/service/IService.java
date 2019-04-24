package com.liuhll.hl.common.service;

import java.util.List;

public interface IService<T> {

    T selectById(Object id);

    List<T> selectAll();

    int save(T entity);

    void deleteById(Object id);

    int batchDelete(List<String> list, String property, Class<T> clazz);

    int updateAll(T entity);

    int updateNotNull(T entity);

}
