package com.licenta.service;

import com.licenta.Utils.RandomUUIDGenerator;
import com.licenta.model.User;
import com.licenta.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {


    @Autowired
    private UserDaoImpl userDao;

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
}
