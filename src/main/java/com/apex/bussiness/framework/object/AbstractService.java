package com.apex.bussiness.framework.object;

import java.util.List;

public interface AbstractService<T, PK> {

     T insert(T entity);

    void  insertList(List<T> entities) ;

    boolean removeByPrimaryKey(PK primaryKey);

    boolean updateSelective(T entity);

     T getByPrimaryKey(PK primaryKey);

     List<T> listAll();
}
