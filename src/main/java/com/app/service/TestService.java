package com.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author juancarrillo
 *         Date: 24/10/13
 */

@Service
@Transactional
public class TestService {

    @Autowired
    SessionFactory sessionFactory;

    public void main() {

    }

//    @Transactional
    public void test() {
        Session session = sessionFactory.getCurrentSession();
    }
}
