package com.licenta.service;

import com.licenta.model.Doctor;
import com.licenta.model.User;
import com.licenta.repository.DoctorDaoImpl;
import com.licenta.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorService {


    @Autowired
    private DoctorDaoImpl doctorDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Integer create(Doctor doctor) {
        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
        return doctorDao.create(doctor);
    }


    public Doctor loginDoctor(String email, String password, String role) {
        Doctor doctorFounded = doctorDao.getDoctorByEmail(email);
        if (doctorFounded != null) {
            if (bCryptPasswordEncoder.matches(password, doctorFounded.getPassword())) {

                if (doctorFounded.getType().equals(role)) {
                    return doctorFounded;
                }

            }
        }
        return null;

    }

    public boolean notExistsEmail(String email) {
        Doctor doctorFromDB = doctorDao.getDoctorByEmail(email);
        return doctorFromDB == null;
    }
}
