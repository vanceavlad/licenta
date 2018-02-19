package com.licenta.facade.reversepopulator;


import com.licenta.dto.AdminDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Admin;
import com.licenta.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminReversePopulator {


    public AdminReversePopulator() {

    }

    public Admin adminDTOToModel(AdminDTO model) {

        Admin admin = new Admin();
        if (model != null) {
            admin.setEmail(model.getEmail());
            admin.setPassword(model.getPassword());

        }
        return admin;

    }

}
