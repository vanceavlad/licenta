package com.licenta.repository;


import com.licenta.model.Allergy;
import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AllergyDaoImpl implements AbstractDao<Allergy, Integer> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Allergy findById(Integer entityId) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(Allergy.class, entityId);
    }

    @Override
    public List<Allergy> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Allergy ", Allergy.class).list();
    }

    @Override
    public Integer create(Allergy entity) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(entity);    }

    @Override
    public void update(Allergy entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }
}
