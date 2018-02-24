package com.licenta.facade.populator;


import com.licenta.dto.UserDTO;
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



    public UserDTO userFromModelToDTO(User model) {

        UserDTO userGenericDTO = new UserDTO();
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


}
