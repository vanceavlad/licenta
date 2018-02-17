package com.licenta.service;


import com.licenta.model.Admin;
import com.licenta.model.Doctor;
import com.licenta.repository.AdminDaoImpl;
import com.licenta.repository.DoctorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {


    @Autowired
    private AdminDaoImpl adminDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Integer create(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        return adminDao.create(admin);
    }


    public Admin loginAdmin(String email, String password) {
        Admin adminFounded = adminDao.getAdminByEmail(email);
        if (adminFounded != null) {
            if (bCryptPasswordEncoder.matches(password, adminFounded.getPassword())) {
                return adminFounded;


            }
        }
        return null;

    }
}
