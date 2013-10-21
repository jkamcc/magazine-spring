package com.app.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 20/10/13
 * Time: 09:15
 * To change this template use File | Settings | File Templates.
 */
public interface DaoOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}
