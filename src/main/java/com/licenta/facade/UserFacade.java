package com.licenta.facade;


import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.User;
import com.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserReversePopulator userGenericReversePopulator;


    public Integer addUser(UserGenericDTO userGenericDTO) {
        User user = userGenericReversePopulator.userDtoToModelInsertion(userGenericDTO);
        return userService.create(user);
    }

}
