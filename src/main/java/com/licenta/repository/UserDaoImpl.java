package com.licenta.repository;

import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements AbstractDao<User, Integer> {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findById(Integer entityId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, entityId);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User ", User.class).list();
    }

    @Override
    public Integer create(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(user);
    }


    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public boolean delete(Integer entityId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, entityId);
        session.delete(user);
//        System.out.println("Session contains object: " + session.contains(user));
        return !session.contains(user);
    }
}
