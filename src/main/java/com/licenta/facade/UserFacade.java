package com.licenta.facade;


import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.populator.UserPopulator;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import com.licenta.service.DoctorService;
import com.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacade {


    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;


    @Autowired
    private UserReversePopulator userGenericReversePopulator;

    @Autowired
    private UserPopulator userPopulator;


    public static final String DOCTOR = "DOCTOR";
    public static final String USER = "USER";


    public Integer addUser(UserGenericDTO userGenericDTO) {
        User user = userGenericReversePopulator.userDtoToModelInsertion(userGenericDTO);
        return userService.create(user);
    }

    public Integer addDoctor(UserGenericDTO userGenericDTO) {
        Doctor doctor = userGenericReversePopulator.doctorToModelIsertion(userGenericDTO);
        return doctorService.create(doctor);
    }

    public UserGenericDTO doLogin(UserGenericDTO userGenericDTO) {
        UserGenericDTO userForListing = new UserGenericDTO();
        if (userGenericDTO.getRole().equals(USER)) {

            User userFromServer = userService.loginUser(userGenericDTO.getEmail(), userGenericDTO.getPassword(),
                    userGenericDTO.getRole());
            userForListing = userPopulator.userFromServerToUserDTO(userFromServer);
        } else {

            Doctor doctorFromServer = doctorService.loginDoctor(userGenericDTO.getEmail(), userGenericDTO.getPassword(),
                    userGenericDTO.getRole());
            userForListing = userPopulator.doctorFromServerToDoctorDTO(doctorFromServer);
        }


        return userForListing;
    }

    public String getPageForType(String role) {
        String page = "";

        if (role.equals(DOCTOR)) {
            page = "redirect:/doctor/myProfile";
        } else {
            page = "redirect:/user/myProfile";
        }
        return page;
    }

    public UserGenericDTO getUserByUniqueKey(String uniqKey) {
        User user = userService.findUserByUniqueKey(uniqKey);
        UserGenericDTO userGenericDTO = userPopulator.userFromServerToUserDTO(user);
        return userGenericDTO;
    }

    public void addAllergiesForUser(UserGenericDTO user, List<String> allergyIds) {
//        User userModel = userGenericReversePopulator.userDtoToModelInsertion(user);
        userService.addAllergiesForUser(user.getEmail(), allergyIds);
    }
}
