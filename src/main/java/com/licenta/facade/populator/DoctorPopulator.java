package com.licenta.facade.populator;

import com.licenta.dto.DoctorDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorPopulator {


    private static final String DOCTOR = "DOCTOR";
    private static final String USER = "USER";

    public DoctorDTO doctorFromModelToDTO(Doctor model) {
        DoctorDTO doctorDTO = new DoctorDTO();
        if (model != null && model.getType().equals(DOCTOR)) {
            doctorDTO.setName(model.getName());
            doctorDTO.setEmail(model.getEmail());
            doctorDTO.setLastName(model.getLastName());
//            userGenericDTO.setPassword(model.getPassword());
            doctorDTO.setUsers(model.getUsers());
            doctorDTO.setDoctorRequests(model.getDoctorRequests());
            doctorDTO.setRole(DOCTOR);
        }
        return doctorDTO;
    }
}
