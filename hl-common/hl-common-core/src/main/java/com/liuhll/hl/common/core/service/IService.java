package com.liuhll.hl.common.core.service;

import java.util.List;

public interface IService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int batchDelete(List<String> list, String property, Class<T> clazz);

    int update(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

}
