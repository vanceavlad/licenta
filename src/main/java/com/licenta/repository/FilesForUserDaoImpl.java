package com.licenta.repository;

import com.licenta.model.DoctorRequest;
import com.licenta.model.FileForUser;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class FilesForUserDaoImpl implements AbstractDao<FileForUser,Integer> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public FileForUser findById(Integer entityId) {
        return null;
    }

    @Override
    public List<FileForUser> getAll() {
        return null;
    }

    @Override
    public Integer create(FileForUser entity) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(entity);    }

    @Override
    public void update(FileForUser entity) {

    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }

    public void saveOrUpdate(FileForUser entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public FileForUser findByCode(String code) {

        FileForUser foundFile;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from FileForUser where code =:code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        try {
            foundFile = (FileForUser) query.getSingleResult();
        } catch (NoResultException nre) {
            foundFile = null;
        }
        return foundFile;

    }
}
