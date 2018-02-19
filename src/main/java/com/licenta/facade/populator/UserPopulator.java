package com.licenta.facade.populator;


import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPopulator {


    private static final String DOCTOR = "DOCTOR";
    private static final String USER = "USER";

    public UserPopulator() {

    }



    public UserGenericDTO userFromModelToDTO(User model) {

        UserGenericDTO userGenericDTO = new UserGenericDTO();
        if (model != null && model.getType().equals(USER)) {
            userGenericDTO.setName(model.getName());
            userGenericDTO.setEmail(model.getEmail());
            userGenericDTO.setLastName(model.getLastName());
//            userGenericDTO.setPassword(model.getPassword());
            userGenericDTO.setRole(USER);
            userGenericDTO.setUniqKey(model.getUniqKeyGenerated());
            userGenericDTO.setAllergies(model.getAllergies());
        }
        return userGenericDTO;

    }


    public UserGenericDTO doctorFromModelToDTO(Doctor model) {
        UserGenericDTO userGenericDTO = new UserGenericDTO();
        if (model != null && model.getType().equals(DOCTOR)) {
            userGenericDTO.setName(model.getName());
            userGenericDTO.setEmail(model.getEmail());
            userGenericDTO.setLastName(model.getLastName());
//            userGenericDTO.setPassword(model.getPassword());
            userGenericDTO.setRole(USER);
        }
        return userGenericDTO;
    }
}
