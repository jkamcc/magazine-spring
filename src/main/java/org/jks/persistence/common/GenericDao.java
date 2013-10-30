package org.jks.persistence.common;

import java.util.List;

/**
 * @author juancarrillo
 */
public interface GenericDao<E, K> {

    void create(E entity);

    E findOne(K key);

    List<E> findAll();

    List<E> find(int start, int end);

    E update(E entity);

    void delete(E entity);

}
