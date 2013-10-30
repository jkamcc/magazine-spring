package org.jks.persistence;

import org.jks.domain.User;
import org.jks.persistence.common.GenericDao;


/**
 * @author juancarrillo
 */
public interface UserDao extends GenericDao<User, Long> {

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    void deleteUserById(long userId);

}
