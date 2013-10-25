package org.jks.persistence;
import org.jks.model.User;

/**
 * @author juancarrillo
 *         Date: 23/10/13
 */
public interface UserDao  {

    void addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(User user);

    void deleteUserById(int id);

}
