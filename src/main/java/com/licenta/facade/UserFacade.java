package com.licenta.facade;


import com.licenta.dto.DoctorDTO;
import com.licenta.dto.FileForUserDTO;
import com.licenta.dto.UserDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.populator.FilesForUserPopulator;
import com.licenta.facade.populator.UserPopulator;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.Doctor;
import com.licenta.model.FileForUser;
import com.licenta.model.User;
import com.licenta.service.DoctorService;
import com.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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

    @Autowired
    private FilesForUserPopulator filesForUserPopulator;


    public static final String DOCTOR = "DOCTOR";
    public static final String USER = "USER";


    public Integer addUser(UserDTO userGenericDTO) {
        User user = userGenericReversePopulator.userFromDTOToModel(userGenericDTO);
        return userService.create(user);
    }


    public UserDTO doLogin(UserDTO userGenericDTO) {
        UserDTO userForListing = new UserDTO();
        if (userGenericDTO.getRole().equals(USER)) {

            User userFromServer = userService.loginUser(userGenericDTO.getEmail(), userGenericDTO.getPassword(),
                    userGenericDTO.getRole());
            userForListing = userPopulator.userFromModelToDTO(userFromServer);
        }
//        else {
//
//            Doctor doctorFromServer = doctorService.loginDoctor(userGenericDTO.getEmail(), userGenericDTO.getPassword(),
//                    userGenericDTO.getRole());
//            userForListing = userPopulator.doctorFromModelToDTO(doctorFromServer);
//        }


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

    public UserDTO getUserByUniqueKey(String uniqKey) {
        User user = userService.findUserByUniqueKey(uniqKey);
        UserDTO userGenericDTO = userPopulator.userFromModelToDTO(user);
        return userGenericDTO;
    }

    public void addAllergiesForUser(UserDTO user, List<String> allergyIds) {
//        User userModel = userGenericReversePopulator.userDtoToModelInsertion(user);
        userService.addAllergiesForUser(user.getEmail(), allergyIds);
    }

    public void connectDoctorWithUser(String email, UserDTO userGenericDTO) {
        User  user = userGenericReversePopulator.userFromDTOToModel(userGenericDTO);
        userService.connectDoctorWithUser(email,user);

    }

    public Set<FileForUserDTO> getFilesForUser(UserDTO userGenericDTO) {
        User user = userGenericReversePopulator.userFromDTOToModel(userGenericDTO);
        Set<FileForUser> filesForUser = userService.getAllFilesForUser(user);
        return filesForUserPopulator.fileForUserModelToDTOS(filesForUser);
    }
}
