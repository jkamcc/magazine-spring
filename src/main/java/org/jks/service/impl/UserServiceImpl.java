package org.jks.service.impl;

import org.jks.domain.User;
import org.jks.persistence.UserDao;
import org.jks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author juancarrillo
 * Date: 23/10/13
@Transactional(propagation= Propagation.REQUIRED)
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.create(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findOne(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
