package com.licenta.repository;

import com.licenta.model.Address;
import com.licenta.model.Admin;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddressDaoImpl implements AbstractDao<Address,Integer> {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Address findById(Integer entityId) {
        return null;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Integer create(Address entity) {
        return null;
    }

    @Override
    public void update(Address entity) {

    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }

    public void saveOrUpdate(Address entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

}
