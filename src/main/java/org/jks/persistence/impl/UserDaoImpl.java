package org.jks.persistence.impl;

import org.jks.domain.User;
import org.jks.persistence.UserDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

/**
 * @author juancarrillo
 * Date: 20/10/13
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDAO<User> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        return findOne(id);
    }

    @Override
    public void updateUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteUserById(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
