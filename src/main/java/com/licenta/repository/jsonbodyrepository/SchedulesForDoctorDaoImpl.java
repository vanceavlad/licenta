package com.licenta.repository.jsonbodyrepository;

import com.licenta.model.ScheduleForDoctor;
import com.licenta.model.User;
import com.licenta.repository.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchedulesForDoctorDaoImpl  implements AbstractDao<ScheduleForDoctor,Integer> {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public ScheduleForDoctor findById(Integer entityId) {
        return null;
    }

    @Override
    public List<ScheduleForDoctor> getAll() {
        return null;
    }

    @Override
    public Integer create(ScheduleForDoctor entity) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(entity);
    }

    @Override
    public void update(ScheduleForDoctor entity) {

    }

    @Override
    public boolean delete(Integer entityId) {
        return false;
    }

    public void saveOrUpdate(ScheduleForDoctor entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

}
