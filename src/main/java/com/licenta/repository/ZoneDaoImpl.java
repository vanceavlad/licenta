package com.licenta.repository;

import com.licenta.model.Allergy;
import com.licenta.model.Zone;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ZoneDaoImpl implements AbstractDao<Zone, Integer> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Zone findById(Integer entityId) {
        return null;
    }

    @Override
    public List<Zone> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Zone", Zone.class).list();
    }

    @Override
    public Integer create(Zone entity) {
        return null;
    }

    @Override
    public void update(Zone entity) {

    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }
}
