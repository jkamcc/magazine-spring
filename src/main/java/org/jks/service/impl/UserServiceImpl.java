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
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getUsers(int start, int end) {
        return null;
    }
}
