package com.licenta.repository;

import com.licenta.model.Doctor;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DoctorDaoImpl implements AbstractDao<Doctor, Integer> {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Doctor findById(Integer entityId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Doctor.class, entityId);
    }

    @Override
    public List<Doctor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Doctor ", Doctor.class).list();
    }

    public Integer create(Doctor doctor) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(doctor);
    }

    @Override
    public void update(Doctor entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public boolean delete(Integer entityId) {
        Session session = sessionFactory.getCurrentSession();
        Doctor doctor = session.get(Doctor.class, entityId);
        session.delete(doctor);
        return !session.contains(doctor);
    }
}
