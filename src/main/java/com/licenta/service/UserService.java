package com.licenta.service;

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



    public Integer create(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

}
