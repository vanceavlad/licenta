package com.licenta.repository;

import com.licenta.model.Admin;
import com.licenta.model.Allergy;
import com.licenta.model.Doctor;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class AdminDaoImpl implements AbstractDao<Admin,Integer>{



    @Autowired
    private SessionFactory sessionFactory;


    public Admin getAdminByEmail(String email) {

        Admin admin;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Admin where email =:email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        try {
            admin = (Admin) query.getSingleResult();
        } catch (NoResultException nre) {
            admin = null;
        }
        return admin;
    }

    @Override
    public Admin findById(Integer entityId) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public Integer create(Admin entity) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(entity);    }

    @Override
    public void update(Admin entity) {

    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }
}
