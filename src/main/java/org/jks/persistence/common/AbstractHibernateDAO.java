package org.jks.persistence.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDAO<T, E extends Serializable> implements GenericDao<T, E>{

    protected Class<? extends T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    @Override
    public final void create(T entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public T findOne(E key) {
        return (T) getCurrentSession().get(clazz, key);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createCriteria(clazz.getName()).list();
                //getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

//    @Override
    public T update( T entity) {
//        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
//        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
