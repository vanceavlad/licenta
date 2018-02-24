package com.licenta.service;

import com.licenta.Utils.RandomUUIDGenerator;
import com.licenta.model.*;
import com.licenta.repository.AllergyDaoImpl;
import com.licenta.repository.DoctorDaoImpl;
import com.licenta.repository.DoctorRequestDaoImpl;
import com.licenta.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class UserService {


    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private DoctorDaoImpl doctorDao;

    @Autowired
    private AllergyDaoImpl allergyDao;

    @Autowired
    private DoctorRequestDaoImpl doctorRequestDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private RandomUUIDGenerator randomUUIDGenerator;

    public Integer create(User user) {
        String uniqKey = randomUUIDGenerator.getRandomUUID().toString();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUniqKeyGenerated(uniqKey);
        return userDao.create(user);
    }

    public User loginUser(String email, String password, String role) {
        User userFounded = userDao.getUserByEmail(email);
        if (userFounded != null) {
            if (bCryptPasswordEncoder.matches(password, userFounded.getPassword())) {

                if (userFounded.getType().equals(role)) {
                    return userFounded;
                }

            }
        }
        return null;

    }


    public boolean notExistsEmail(String email) {
        User userFromDb = userDao.getUserByEmail(email);
        return userFromDb == null;
    }

    public User findUserByUniqueKey(String uniqKey) {
        return userDao.findByUniqueKey(uniqKey);
    }

    public void addAllergiesForUser(String email, List<String> allergyIds) {
        List<Allergy> allergies = new ArrayList<>();

        User userToChange = userDao.getUserByEmail(email);

        if (allergyIds != null) {
            for (String id : allergyIds) {
                Allergy allergy = allergyDao.findById(Integer.parseInt(id));
                if (!allergies.contains(allergy)) {
                    allergies.add(allergy);
                }
            }
        }
//        else
//        {
//
//
//        }

        userToChange.setAllergies(allergies);
        userDao.update(userToChange);


    }

    public void connectDoctorWithUser(String email, User user) {

        Doctor doctor = doctorDao.getDoctorByEmail(email);
        user = userDao.getUserByEmail(user.getEmail());
        Set<User> users = doctor.getUsers();
        if (!users.contains(user)) {
            users.add(user);
        }
        doctor.setUsers(users);
        doctorDao.update(doctor);
        deleteRequestFromDoctor(doctor, user);

    }


    public void deleteRequestFromDoctor(Doctor doctor, User user) {
        List<DoctorRequest> doctorRequestList = new ArrayList<>();
        doctorRequestList = doctor.getDoctorRequests();
        for (DoctorRequest dr : doctorRequestList) {
            if (dr.getUser().equals(user.getEmail())) {
                doctorRequestDao.delete(dr.getId());
                doctorRequestList.remove(dr);
                if (doctorRequestList.size() == 0) {
                    break;
                }
            }
        }
        doctor.setDoctorRequests(doctorRequestList);

        doctorDao.update(doctor);
    }

    public User getUserByEmail(String userEmail) {
        return userDao.getUserByEmail(userEmail);
    }

    public Set<FileForUser> getAllFilesForUser(User user) {
        user = userDao.getUserByEmail(user.getEmail());

        Set<FileForUser> filesForUser = new HashSet<>();


        filesForUser.addAll(user.getFilesForUser());



        return filesForUser;

    }
}

class MyDateComparator implements Comparator<FileForUser>{

    @Override
    public int compare(FileForUser e1, FileForUser e2) {
        return e2.getDate().compareTo(e1.getDate());
    }
}

