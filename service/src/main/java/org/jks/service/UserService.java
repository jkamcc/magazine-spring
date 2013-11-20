package org.jks.service;

import org.jks.domain.User;

import java.util.List;

/**
 * @author juancarrillo
 * Date: 23/10/13
 */
public interface UserService {

    public void addUser(User user);

    public User getUserById(long userId);

    public User getUserByEmail(String email);

    public List<User> getUsers();

    public List<User> getUsers(int start, int end);

    public User getUserByUsername(String username);

    public boolean checkExistUsername(String username);

    public boolean checkExistPassword(String password);

    public void updateUser(User user);

    public void deleteUser(User user);

    public void deleteUserById(long userId);
}
