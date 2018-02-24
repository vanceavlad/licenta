package com.licenta.service;

import com.licenta.Utils.SendEmail;
import com.licenta.model.Doctor;
import com.licenta.model.DoctorRequest;
import com.licenta.model.User;
import com.licenta.repository.DoctorDaoImpl;
import com.licenta.repository.DoctorRequestDaoImpl;
import com.licenta.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DoctorService {


    @Autowired
    private DoctorDaoImpl doctorDao;

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    DoctorRequestDaoImpl doctorRequestDao;

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

    public String sendConnectingEmail(Doctor doctor, User user) {
        String emailAddress = user.getEmail();
        String subject = "Connection request from " + doctor.getName() + " " + doctor.getLastName();
        String message = "Please connect with me. Follow the next url:\n http://localhost:8080/user/confirm/" + doctor.getEmail();
        SendEmail email = new SendEmail(emailAddress, subject, message);

        return email.sendEmail(emailAddress);
    }

    public List<DoctorRequest> createRequest(Doctor doctor, User user) {
        DoctorRequest doctorRequest = new DoctorRequest();
        List<DoctorRequest> doctorRequestList = new ArrayList<>();

        user = userDao.getUserByEmail(user.getEmail());

        doctor = doctorDao.getDoctorByEmail(doctor.getEmail());
        doctorRequest.setUser(user.getEmail());
        doctorRequest.setDate(new Date());
        doctorRequest.setDoctor(doctor);
//        doctorRequestDao.saveOrUpdate(doctorRequest);

        doctor = doctorDao.getDoctorByEmail(doctor.getEmail());

        doctorRequestDao.saveOrUpdate(doctorRequest);


        doctorRequestList.addAll(doctor.getDoctorRequests());

        if (!doctorRequestList.contains(doctorRequest)) {
            doctorRequestList.add(doctorRequest);
        }

        doctor.setDoctorRequests(doctorRequestList);
        doctorDao.saveOrUpdate(doctor);

        return doctor.getDoctorRequests();
    }

    public boolean verifyIfDoctorHasUser(Doctor doctorModel, User userModel) {
        Set<User> users = doctorModel.getUsers();

        for(User user : users){
            if(user.equals(userModel)){
                return true;
            }
        }
        return false;
    }
}
