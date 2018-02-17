package com.licenta.facade;


import com.licenta.dto.AdminDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.populator.AdminPopulator;
import com.licenta.facade.reversepopulator.AdminReversePopulator;
import com.licenta.model.Admin;
import com.licenta.model.Doctor;
import com.licenta.model.User;
import com.licenta.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminFacade {


    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminReversePopulator adminReversePopulator;

    @Autowired
    private AdminPopulator adminPopulator;


    public AdminDTO doLogin(AdminDTO adminDTO) {
        AdminDTO adminForPage = new AdminDTO();

        Admin adminFromServer = adminService.loginAdmin(adminDTO.getEmail(), adminDTO.getPassword());
        adminForPage = adminPopulator.adminFromServerToAdminDTO(adminFromServer);
        return adminForPage;
    }

    public Integer createAdmin(AdminDTO adminDTO) {
        Admin doctor = adminReversePopulator.adminDtoToModelInsertion(adminDTO);
        return adminService.create(doctor);
    }

}

