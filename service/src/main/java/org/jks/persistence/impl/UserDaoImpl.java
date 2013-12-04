package org.jks.persistence.impl;

import com.google.common.base.Preconditions;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.User;
import org.jks.persistence.UserDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        String hsql = "select u.username from "+ User.class.getName() +" as u where u.username = :username";

        Query query =  getCurrentSession().createQuery(hsql);
        query.setParameter("username", username);
        String result = (String) query.uniqueResult();

        if (result != null && !result.equals("")) {
            existUsername = true;
        }
        return existUsername;
    }

    @Override
    public boolean checkExistPassword(String password) {
        boolean existPassword = false;

        String hsql = "select u.password from "+ User.class.getName() +" as u where u.password = :password";

        Query query =  getCurrentSession().createQuery(hsql);
        query.setParameter("password", password);

        String result = (String) query.uniqueResult();

        if (result != null && !result.equals("")) {
            existPassword = true;
        }

        return existPassword;
    }

    @Override
    public List<User> find(int start, int end) {

        String hsql = "FROM " + User.class.getName() + " as a ORDER BY a.username asc ";
        Query q = getCurrentSession().createQuery(hsql);

        if (start > 0) {
            q.setFirstResult(start);
        }

        if (end > 0) {
            q.setMaxResults(end);
        }
        return q.list();
    }
}
