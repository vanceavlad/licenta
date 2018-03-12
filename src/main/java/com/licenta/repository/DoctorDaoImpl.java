package com.licenta.repository;

import com.licenta.model.Doctor;
import com.licenta.model.DoctorRequest;
import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.print.Doc;
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


    public Doctor getDoctorByEmail(String email) {
        Doctor soughtDoctor;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Doctor where email =:email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        try {
            soughtDoctor = (Doctor) query.getSingleResult();
        } catch (NoResultException nre) {
            soughtDoctor = null;
        }
        return soughtDoctor;
    }

    public void saveOrUpdate(Doctor entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }


    public Doctor getDoctorByUniqueKey(String uniqueKey) {
        Doctor foundedDoctor;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Doctor where uniqKeyGenerated =:uniqKeyGenerated";
        Query query = session.createQuery(hql);
        query.setParameter("uniqKeyGenerated", uniqueKey);
        try {
            foundedDoctor = (Doctor) query.getSingleResult();
        } catch (NoResultException nre) {
            foundedDoctor = null;
        }
        return foundedDoctor;
    }
}
