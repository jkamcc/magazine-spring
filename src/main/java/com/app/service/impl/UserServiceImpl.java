package com.app.service.impl;

import com.app.persistence.dao.UserDao;
import com.app.persistence.dao.common.DaoOperations;
import com.app.persistence.model.User;
import com.app.service.UserService;
import com.app.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author juancarrillo
 * Date: 23/10/13
@Transactional(propagation= Propagation.REQUIRED)
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        super();
    }

    @Override
    protected DaoOperations<User> getDao() {
        return userDao;
    }
}
