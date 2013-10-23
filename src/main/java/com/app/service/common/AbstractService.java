package com.app.service.common;

import com.app.persistence.dao.common.DaoOperations;

import java.io.Serializable;
import java.util.List;

/**
 * @author juancarrillo
 * Date: 23/10/13
 */
public abstract class AbstractService<T extends Serializable> implements DaoOperations<T> {

    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract DaoOperations<T> getDao();
}
