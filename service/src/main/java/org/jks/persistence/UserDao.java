package org.jks.persistence;

import org.jks.domain.User;
import org.jks.persistence.common.GenericDao;


/**
 * @author juancarrillo
 */
public interface UserDao extends GenericDao<User, Long> {

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    boolean checkExistUsername(String username);

    boolean checkExistPassword(String password);

}
