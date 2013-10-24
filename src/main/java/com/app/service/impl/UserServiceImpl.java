package com.app.service.impl;

import com.app.persistence.dao.UserDao;
import com.app.persistence.dao.common.DaoOperations;
import com.app.persistence.model.User;
import com.app.service.UserService;
import com.app.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author juancarrillo
 * Date: 23/10/13
@Transactional(propagation= Propagation.REQUIRED)
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        super();
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected DaoOperations<User> getDao() {
        return userDao;
    }
}
