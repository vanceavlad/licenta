package com.licenta.facade;


import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import com.licenta.service.DoctorService;
import com.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;


    @Autowired
    private UserReversePopulator userGenericReversePopulator;


    public Integer addUser(UserGenericDTO userGenericDTO) {
        User user = userGenericReversePopulator.userDtoToModelInsertion(userGenericDTO);
        return userService.create(user);
    }

    public Integer addDoctor(UserGenericDTO userGenericDTO) {
        Doctor doctor = userGenericReversePopulator.doctorToModelIsertion(userGenericDTO);
        return doctorService.create(doctor);
    }
}
