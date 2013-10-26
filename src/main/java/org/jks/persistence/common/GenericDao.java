package org.jks.persistence.common;

import java.util.List;

/**
 * @author juancarrillo
 */
public interface GenericDao<E, K> {

    void create(E entity);

    E findOne(K key);

    List<E> findAll();

    E update(E entity);

    void delete(E entity);

}
