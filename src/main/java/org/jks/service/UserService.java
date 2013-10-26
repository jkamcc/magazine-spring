package org.jks.service;

import org.jks.domain.User;

import java.util.List;

/**
 * @author juancarrillo
 * Date: 23/10/13
 */
public interface UserService {

    public void addUser(User user);

    public User getUserById(int userId);

    public User getUserByEmail(String email);

    public List<User> getUsers();

    public User getUserByUsername(String username);
}
