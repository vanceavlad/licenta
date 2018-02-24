package com.licenta.repository;

import com.licenta.model.FileForUser;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
