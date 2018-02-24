package com.licenta.facade.reversepopulator;


import com.licenta.dto.UserDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserReversePopulator {

    private static final String DOCTOR = "DOCTOR";
    private static final String USER = "USER";

    public UserReversePopulator() {

    }

    public User userFromDTOToModel(UserDTO model) {

        User user = new User();
        if (model != null && model.getRole().equals(USER)) {
            user.setName(model.getName());
            user.setEmail(model.getEmail());
            user.setLastName(model.getLastName());
            user.setPassword(model.getPassword());
            user.setActive(1);
            user.setType(USER);

        }
        return user;

    }

}
