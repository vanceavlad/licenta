package com.licenta.facade.reversepopulator;

import com.licenta.dto.AddressDTO;
import com.licenta.dto.DoctorDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Address;
import com.licenta.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorReversePopulator {

    private static final String DOCTOR = "DOCTOR";
    private static final String USER = "USER";

    public Doctor doctorFromDTOToModel(DoctorDTO model) {
        Doctor doctor = new Doctor();
        Address address = new Address();
        if (model != null && model.getRole().equals(DOCTOR)) {

            doctor.setName(model.getName());
            doctor.setEmail(model.getEmail());
            doctor.setLastName(model.getLastName());
            doctor.setPassword(model.getPassword());
            doctor.setUsers(model.getUsers());
            doctor.setDoctorRequests(model.getDoctorRequests());
            doctor.setType(DOCTOR);
            doctor.setUniqKeyGenerated(model.getUniqKey());
            AddressDTO addressDTO = model.getAddressDTO();
            if(addressDTO!=null){

                address.setCity(addressDTO.getCity());
                address.setStreetName(addressDTO.getStreet());
                address.setStreetNumber(addressDTO.getNumber());
                address.setTelephoneNumber(addressDTO.getPhone());
                address.setZipCode(addressDTO.getZipCode());
                address.setZone(addressDTO.getZone());

                doctor.setAddress(address);
            }
        }
        return doctor;
    }
}
