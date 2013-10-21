package com.app.persistence.dao;

import com.app.persistence.dao.common.AbstractHibernateDAO;
import com.app.persistence.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 20/10/13
 * Time: 09:07
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDao implements Serializable {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

}
