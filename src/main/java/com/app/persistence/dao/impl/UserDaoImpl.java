package com.app.persistence.dao.impl;

import com.app.persistence.dao.common.AbstractHibernateDAO;
import com.app.persistence.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author juancarrillo
 * Date: 20/10/13
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDAO<User> {

    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
}
