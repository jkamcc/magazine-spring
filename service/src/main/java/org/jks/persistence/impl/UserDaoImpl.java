package org.jks.persistence.impl;

import com.google.common.base.Preconditions;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.User;
import org.jks.persistence.UserDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

/**
 * @author juancarrillo
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDAO<User, Long> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        Preconditions.checkNotNull(username);
        return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    @Override
    public User getUserByEmail(String email) {
        Preconditions.checkNotNull(email);
        return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean existUsername = false;
        String hql = "select u.username from "+ User.class.getName() +" as u where u.username = \'" + username + "\'";

        String result = (String) getCurrentSession().createQuery(hql).uniqueResult();

        if (result != null && !result.equals("")) {
            existUsername = true;
        }
        return existUsername;
    }

    @Override
    public boolean checkExistPassword(String password) {
        boolean existPassword = false;

        String hql = "select u.password from "+ User.class.getName() +" as u where u.password = \'" + password + "\'";

        String result = (String) getCurrentSession().createQuery(hql).uniqueResult();

        if (result != null && !result.equals("")) {
            existPassword = true;
        }

        return existPassword;
    }
}
