package com.licenta.repository;

import com.licenta.model.DoctorRequest;
import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRequestDaoImpl implements AbstractDao<DoctorRequest, Integer> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public DoctorRequest findById(Integer entityId) {
        return null;
    }

    @Override
    public List<DoctorRequest> getAll() {
        return null;
    }

    @Override
    public Integer create(DoctorRequest entity) {
        return null;
    }

    public void saveOrUpdate(DoctorRequest entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void update(DoctorRequest entity) {

    }

    @Override
    public boolean delete(Integer entityId) {

        Session session = sessionFactory.getCurrentSession();
        DoctorRequest doctorRequest = session.get(DoctorRequest.class, entityId);
        session.delete(doctorRequest);
//        System.out.println("Session contains object: " + session.contains(user));
        return !session.contains(doctorRequest);
    }
}
