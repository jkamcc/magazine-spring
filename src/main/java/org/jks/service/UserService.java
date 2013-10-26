package org.jks.service;

import org.jks.domain.User;

import java.util.List;

/**
 * @author juancarrillo
 * Date: 23/10/13
 */
public interface UserService {

    public User getUserById(int userId);

    public List<User> getUsers(int start, int end);

}
