package com.licenta.facade.reversepopulator;


import com.licenta.dto.UserGenericDTO;
import com.licenta.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserReversePopulator {

    public UserReversePopulator() {

    }

    public User userDtoToModelInsertion(UserGenericDTO model) {
        User user = new User();
        if (model != null) {
            user.setName(model.getName());
            user.setEmail(model.getEmail());
            user.setLastName(model.getLastName());
            user.setPassword(model.getPassword());
            user.setActive(1);
        }
        return user;
    }

}
