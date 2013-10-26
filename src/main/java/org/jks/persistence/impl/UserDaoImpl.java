package org.jks.persistence.impl;

import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.User;
import org.jks.persistence.UserDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

/**
 * @author juancarrillo
 * Date: 20/10/13
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDAO<User, Integer> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }
}
