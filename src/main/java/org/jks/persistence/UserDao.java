package org.jks.persistence;

import org.jks.domain.User;
import org.jks.persistence.common.GenericDao;

import java.util.List;

/**
 * @author juancarrillo
 */
public interface UserDao extends GenericDao<User, Integer> {

    User getUserByEmail(String email);

    User getUserByUsername(String username);

}
