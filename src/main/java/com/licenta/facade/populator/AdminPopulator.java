package com.licenta.facade.populator;

import com.licenta.dto.AdminDTO;
import com.licenta.model.Admin;
import com.licenta.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminPopulator {


    public AdminPopulator() {
    }


    public AdminDTO adminFromServerToAdminDTO(Admin model) {

        AdminDTO adminDTO = new AdminDTO();
        if (model != null) {
            adminDTO.setEmail(model.getEmail());
        }
        return adminDTO;

    }

}
