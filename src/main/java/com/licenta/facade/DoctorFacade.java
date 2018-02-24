package com.licenta.facade;

import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.Doctor;
import com.licenta.model.DoctorRequest;
import com.licenta.model.User;
import com.licenta.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DoctorFacade {


    @Autowired
    private DoctorService doctorService;

    @Autowired
    UserReversePopulator userReversePopulator;


    public List<DoctorRequest> connectUserWithDoctor(UserGenericDTO doctorDTO, UserGenericDTO userGeneric) {
        User user = userReversePopulator.userFromDTOToModel(userGeneric);
        Doctor doctor = userReversePopulator.doctorFromDTOToModel(doctorDTO);
        String email = doctor.getEmail();
        String result = doctorService.sendConnectingEmail(doctor, user);
        if(result!=null){
           return doctorService.createRequest(doctor,user);
        }
        else{
            return null;
        }
    }

    public boolean verifyIfDoctorHasUser(UserGenericDTO doctor, UserGenericDTO userForListing) {
        User userModel = userReversePopulator.userFromDTOToModel(userForListing);
        Doctor doctorModel = userReversePopulator.doctorFromDTOToModel(doctor);
        return doctorService.verifyIfDoctorHasUser(doctorModel,userModel);
    }
}
