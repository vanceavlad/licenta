package com.licenta.facade.reversepopulator;

import com.licenta.dto.DoctorDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorReversePopulator {

    private static final String DOCTOR = "DOCTOR";
    private static final String USER = "USER";

    public Doctor doctorFromDTOToModel(DoctorDTO model) {
        Doctor doctor = new Doctor();
        if (model != null && model.getRole().equals(DOCTOR)) {

            doctor.setName(model.getName());
            doctor.setEmail(model.getEmail());
            doctor.setLastName(model.getLastName());
            doctor.setPassword(model.getPassword());
            doctor.setUsers(model.getUsers());
            doctor.setDoctorRequests(model.getDoctorRequests());
            doctor.setType(DOCTOR);
        }
        return doctor;
    }
}
